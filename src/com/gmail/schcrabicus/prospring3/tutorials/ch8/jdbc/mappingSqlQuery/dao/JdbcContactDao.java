package com.gmail.schcrabicus.prospring3.tutorials.ch8.jdbc.mappingSqlQuery.dao;

import com.gmail.schcrabicus.prospring3.tutorials.ch8.jdbc.mappingSqlQuery.Contact;
import com.gmail.schcrabicus.prospring3.tutorials.ch8.jdbc.mappingSqlQuery.ContactTelDetail;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.BeanCreationException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: schcrabicus
 * Date: 28.01.13
 * Time: 8:50
 * To change this template use File | Settings | File Templates.
 */
@Repository("contactDao")
public class JdbcContactDao implements IContactDao, InitializingBean{

    private static Logger log = Logger.getLogger(JdbcContactDao.class);

    @Autowired
    private DataSource dataSource;

    private SelectAllContact selectAllContact;

    private SelectContactByFirstName selectContactByFirstName;

    private UpdateContact updateContact;

    private InsertContact insertContact;

    private InsertContactTelDetail insertContactTelDetail;

    @Override
    public List<Contact> findByFirstName(String firstName) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("firstName", firstName);

        return selectContactByFirstName.executeByNamedParam(map);
    }

    @Override
    public List<Contact> findAllWithDetail() {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

        final String SQL_QUERY = "SELECT c.id, c.first_name, c.last_name, c.birth_date, " +
                "t.id as contact_tel_id, t.contact_id, t.tel_type, t.tel_number FROM contact c " +
                "LEFT JOIN contact_tel_detail t " +
                "ON c.id = t.contact_id";

        return jdbcTemplate.query(SQL_QUERY, new ContactWithDetailExtractor());
    }

    @Override
    public List<Contact> findAll() {
        return selectAllContact.execute();
    }

    @Override
    public void create(Contact object) {
        Map<String, Object> map = new HashMap<String, Object>();

        map.put("firstName", object.getFirstName());
        map.put("lastName", object.getLastName());
        map.put("birthDate", object.getBirthDate());

        KeyHolder keyHolder = new GeneratedKeyHolder();
        insertContact.updateByNamedParam(map, keyHolder);
        object.setId(keyHolder.getKey().longValue());

        log.info("Generated key = " + object.getId());
    }

    @Override
    public void createWithDetail(Contact object) {
        Map<String, Object> map = new HashMap<String, Object>();

        map.put("firstName", object.getFirstName());
        map.put("lastName", object.getLastName());
        map.put("birthDate", object.getBirthDate());

        KeyHolder keyHolder = new GeneratedKeyHolder();
        insertContact.updateByNamedParam(map, keyHolder);
        object.setId(keyHolder.getKey().longValue());

        log.info("New contact inserted with id: " + object.getId());

        // Batch insert contact tel. details
        List<ContactTelDetail> contactTelDetails =
                object.getContactTelDetails();
        if (contactTelDetails != null) {
            for (ContactTelDetail contactTelDetail: contactTelDetails) {
                map = new HashMap<String, Object>();
                map.put("contactId", object.getId());
                map.put("telType", contactTelDetail.getTelType());
                map.put("telNumber", contactTelDetail.getTelNumber());
                insertContactTelDetail.updateByNamedParam(map);
            }
        }
        insertContactTelDetail.flush();
    }

    @Override
    public void delete(Contact object) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void update(Contact object) {
        Map<String, Object> map = new HashMap<String, Object>();

        map.put("id", object.getId());
        map.put("firstName", object.getFirstName());
        map.put("lastName", object.getLastName());
        map.put("birthDate", object.getBirthDate());
        updateContact.updateByNamedParam(map);
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        if ( dataSource == null ){
            throw new BeanCreationException("DataSource hasn't been autowired");
        }

        selectAllContact = new SelectAllContact(dataSource);
        selectContactByFirstName = new SelectContactByFirstName(dataSource);
        updateContact = new UpdateContact(dataSource);
        insertContact = new InsertContact(dataSource);
        insertContactTelDetail = new InsertContactTelDetail(dataSource);
    }

    private static final class ContactWithDetailExtractor implements ResultSetExtractor<List<Contact>> {

        @Override
        public List<Contact> extractData(ResultSet resultSet) throws SQLException, DataAccessException {
            Map<Long, Contact> contactMap = new HashMap<Long, Contact>();
            Contact contact;

            while (resultSet.next()){
                Long id = resultSet.getLong("id");
                Long telDetailId = resultSet.getLong("contact_tel_id");
                contact = contactMap.get(id);

                if ( contact == null ){
                    contact = new Contact();

                    contact.setId(id);
                    contact.setFirstName(resultSet.getString("first_name"));
                    contact.setLastName(resultSet.getString("last_name"));
                    contact.setBirthDate(resultSet.getDate("birth_date"));
                    contact.setContactTelDetails(new ArrayList<ContactTelDetail>());

                    contactMap.put(id, contact);
                }

                if ( telDetailId > 0 ){
                    ContactTelDetail detail = new ContactTelDetail();
                    detail.setId(telDetailId);
                    detail.setContactId(id);
                    detail.setTelType(resultSet.getString("tel_type"));
                    detail.setTelNumber(resultSet.getString("tel_number"));

                    contact.getContactTelDetails().add(detail);
                }
            }

            return new ArrayList<Contact>(contactMap.values());
        }
    }
}

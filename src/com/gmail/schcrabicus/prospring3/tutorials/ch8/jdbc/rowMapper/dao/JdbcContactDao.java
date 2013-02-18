package com.gmail.schcrabicus.prospring3.tutorials.ch8.jdbc.rowMapper.dao;

import com.gmail.schcrabicus.prospring3.tutorials.ch8.jdbc.rowMapper.Contact;
import com.gmail.schcrabicus.prospring3.tutorials.ch8.jdbc.rowMapper.ContactTelDetail;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.BeanCreationException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
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
 * Time: 7:47
 * To change this template use File | Settings | File Templates.
 */
@Repository(value = "jdbcContactDao")
public class JdbcContactDao implements IContactDao, InitializingBean {

    private static Logger log = Logger.getLogger(JdbcContactDao.class);

    private JdbcTemplate jdbcTemplate;

    @Autowired
    private DataSource dataSource;

    @Override
    public List<Contact> findByFirstName(String firstName) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public List<Contact> findAllWithDetail() {
        String sql = "SELECT c.id, c.first_name, c.last_name, c.birth_date, " +
                "t.id as contact_tel_id, t.tel_type, t.tel_number FROM contact c " +
                "left join contact_tel_detail t on c.id = t.contact_id";

        return jdbcTemplate.query(sql, new ContactWithDetailExtractor());
    }

    @Override
    public List<Contact> findAll() {
        String sql = "SELECT id, first_name, last_name, birth_date FROM contact";
        return jdbcTemplate.query(sql, new ContactMapper());
    }

    @Override
    public void create(Contact object) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void delete(Contact object) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void update(Contact object) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        if ( dataSource == null ){
            log.error("Datasource was not autowired");
            throw new BeanCreationException("Datasource was not autowired");
        }

        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    private static final class ContactMapper implements RowMapper<Contact> {

        @Override
        public Contact mapRow(ResultSet resultSet, int i) throws SQLException {

            Contact contact = new Contact();
            contact.setId(resultSet.getLong("id"));
            contact.setFirstName(resultSet.getString("first_name"));
            contact.setLastName(resultSet.getString("last_name"));
            contact.setBirthDate(resultSet.getDate("birth_date"));

            return contact;
        }
    }


    private static final class ContactWithDetailExtractor implements ResultSetExtractor<List<Contact>> {

        @Override
        public List<Contact> extractData(ResultSet resultSet) throws SQLException, DataAccessException {
            Map<Long, Contact> map = new HashMap<Long, Contact>();
            Contact contact;

            while (resultSet.next()){
                Long contactId = resultSet.getLong("id");

                contact = map.get(contactId);
                if (contact == null){
                    contact = new Contact();
                    contact.setId(contactId);
                    contact.setFirstName(resultSet.getString("first_name"));
                    contact.setLastName(resultSet.getString("last_name"));
                    contact.setBirthDate(resultSet.getDate("birth_date"));
                    contact.setContactTelDetails(new ArrayList<ContactTelDetail>());
                    map.put(contactId, contact);
                }

                Long contactTelDetailId = resultSet.getLong("contact_tel_id");
                if (contactTelDetailId > 0) {
                    ContactTelDetail contactTelDetail = new ContactTelDetail();
                    contactTelDetail.setId(contactTelDetailId);
                    contactTelDetail.setContactId(contactId);
                    contactTelDetail.setTelType(resultSet.getString("tel_type"));
                    contactTelDetail.setTelNumber(resultSet.getString("tel_number"));
                    contact.getContactTelDetails().add(contactTelDetail);
                }
            }

            return new ArrayList<Contact>(map.values());
        }
    }
}

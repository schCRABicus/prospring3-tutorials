package com.gmail.schcrabicus.prospring3.tutorials.ch8.jdbc.spring.basic.dao;

import com.gmail.schcrabicus.prospring3.tutorials.ch8.jdbc.rowMapper.Contact;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.BeanCreationException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: schcrabicus
 * Date: 25.01.13
 * Time: 7:45
 * To change this template use File | Settings | File Templates.
 */
@Repository
public class JdbcContactDao implements IContactDao, InitializingBean {

    private static Logger log = Logger.getLogger(JdbcContactDao.class);

    private JdbcTemplate jdbcTemplate;

    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Autowired
    private DataSource dataSource;

    @Override
    public List<Contact> findByFirstName(String firstName) {
        return null;
    }

    @Override
    public String findFirstNameById(Long id) {
        return
                jdbcTemplate.queryForObject("SELECT first_name FROM contact WHERE id=?",  new Object[]{id}, String.class);
    }

    @Override
    public String findLastNameById(Long id) {
        String sqlQuery = "select last_name from contact where id = :contactId";

        SqlParameterSource parameterSource = new MapSqlParameterSource("contactId", id);

        return namedParameterJdbcTemplate.queryForObject(sqlQuery, parameterSource, String.class);
    }

    @Override
    public List<Contact> findAll() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
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
            log.error("DataSource hasn't been injected");
            throw new BeanCreationException("DataSource hasn't been injected");
        }
        jdbcTemplate = new JdbcTemplate(dataSource);
        namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
    }
}

package com.gmail.schcrabicus.prospring3.tutorials.ch8.jdbc.mappingSqlQuery.dao;

import com.gmail.schcrabicus.prospring3.tutorials.ch8.jdbc.mappingSqlQuery.Contact;
import org.springframework.jdbc.object.MappingSqlQuery;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created with IntelliJ IDEA.
 * User: schcrabicus
 * Date: 29.01.13
 * Time: 7:48
 * To change this template use File | Settings | File Templates.
 */
public abstract class AbstractMappingSqlQuery extends MappingSqlQuery<Contact> {

    public AbstractMappingSqlQuery(DataSource dataSource, String sql){
        super(dataSource, sql);
    }

    @Override
    protected Contact mapRow(ResultSet resultSet, int i) throws SQLException {
        Contact contact = new Contact();

        contact.setId(resultSet.getLong("id"));
        contact.setFirstName(resultSet.getString("first_name"));
        contact.setLastName(resultSet.getString("last_name"));
        contact.setBirthDate(resultSet.getDate("birth_date"));

        return contact;
    }
}

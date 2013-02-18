package com.gmail.schcrabicus.prospring3.tutorials.ch8.jdbc.mappingSqlQuery.dao;

import com.gmail.schcrabicus.prospring3.tutorials.ch8.jdbc.mappingSqlQuery.Contact;
import org.springframework.jdbc.object.MappingSqlQuery;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created with IntelliJ IDEA.
 * User: schcrabicus
 * Date: 28.01.13
 * Time: 8:52
 * To change this template use File | Settings | File Templates.
 */
public class SelectAllContact extends AbstractMappingSqlQuery {

    private static final String SQL_SELECT_ALL_CONTACT =
            "select id, first_name, last_name, birth_date from contact";

    public SelectAllContact(DataSource dataSource){
        super(dataSource, SQL_SELECT_ALL_CONTACT);
    }
}

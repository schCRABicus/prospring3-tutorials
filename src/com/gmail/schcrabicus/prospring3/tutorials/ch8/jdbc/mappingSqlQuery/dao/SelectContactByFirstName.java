package com.gmail.schcrabicus.prospring3.tutorials.ch8.jdbc.mappingSqlQuery.dao;

import com.gmail.schcrabicus.prospring3.tutorials.ch8.jdbc.mappingSqlQuery.Contact;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.object.MappingSqlQuery;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

/**
 * Created with IntelliJ IDEA.
 * User: schcrabicus
 * Date: 29.01.13
 * Time: 7:27
 * To change this template use File | Settings | File Templates.
 */
public class SelectContactByFirstName extends AbstractMappingSqlQuery {

    private static final String SQL_QUERY = " SELECT id, first_name, last_name, birth_date FROM contact WHERE first_name = :firstName";

    public SelectContactByFirstName(DataSource ds) {
        super(ds, SQL_QUERY);
        super.declareParameter(new SqlParameter("firstName", Types.VARCHAR));

    }
}

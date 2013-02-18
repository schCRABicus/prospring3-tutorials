package com.gmail.schcrabicus.prospring3.tutorials.ch8.jdbc.mappingSqlQuery.dao;

import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.object.SqlUpdate;

import javax.sql.DataSource;
import java.sql.Types;

/**
 * Created with IntelliJ IDEA.
 * User: schcrabicus
 * Date: 29.01.13
 * Time: 7:52
 * To change this template use File | Settings | File Templates.
 */
public class UpdateContact extends SqlUpdate {

    private static final String SQL_QUERY = "UPDATE contact " +
            "SET " +
            "first_name = :firstName, " +
            "last_name = :lastName, " +
            "birth_date = :birthDate " +
            "WHERE id = :id";

    public UpdateContact(DataSource dataSource){
        super(dataSource, SQL_QUERY);
        super.declareParameter(new SqlParameter("id", Types.INTEGER));
        super.declareParameter(new SqlParameter("firstName", Types.VARCHAR));
        super.declareParameter(new SqlParameter("lastName", Types.VARCHAR));
        super.declareParameter(new SqlParameter("birthDate", Types.DATE));
    }
}

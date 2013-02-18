package com.gmail.schcrabicus.prospring3.tutorials.ch8.jdbc.mappingSqlQuery.dao;

import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.object.SqlUpdate;

import javax.sql.DataSource;
import java.sql.Types;

/**
 * Created with IntelliJ IDEA.
 * User: schcrabicus
 * Date: 29.01.13
 * Time: 8:09
 * To change this template use File | Settings | File Templates.
 */
public class InsertContact extends SqlUpdate {

    private static final String SQL_QUERY = "INSERT INTO contact (first_name, last_name, birth_date) " +
            "VALUES (:firstName, :lastName, :birthDate)";

    public InsertContact(DataSource dataSource){
        super(dataSource, SQL_QUERY);
        super.declareParameter(new SqlParameter("firstName", Types.VARCHAR));
        super.declareParameter(new SqlParameter("lastName", Types.VARCHAR));
        super.declareParameter(new SqlParameter("birthDate", Types.DATE));
        super.setGeneratedKeysColumnNames(new String[] {"id"});
        super.setReturnGeneratedKeys(true);
    }
}

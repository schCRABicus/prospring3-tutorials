package com.gmail.schcrabicus.prospring3.tutorials.ch8.jdbc.mappingSqlQuery.dao;

import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.object.BatchSqlUpdate;

import javax.sql.DataSource;
import java.sql.Types;

/**
 * Created with IntelliJ IDEA.
 * User: schcrabicus
 * Date: 29.01.13
 * Time: 8:21
 * To change this template use File | Settings | File Templates.
 */
public class InsertContactTelDetail extends BatchSqlUpdate {

    private static final String SQL_QUERY = "INSERT INTO contact_tel_detail (contact_id, tel_type, tel_number) " +
            "VALUES (:contactId, :telType, :telNumber)";

    private static final int BATCH_SIZE = 10;

    public InsertContactTelDetail(DataSource dataSource){
        super(dataSource, SQL_QUERY);
        super.declareParameter(new SqlParameter("contactId", Types.INTEGER));
        super.declareParameter(new SqlParameter("telType", Types.VARCHAR));
        super.declareParameter(new SqlParameter("telNumber", Types.VARCHAR));
        super.setBatchSize(BATCH_SIZE);
    }
}

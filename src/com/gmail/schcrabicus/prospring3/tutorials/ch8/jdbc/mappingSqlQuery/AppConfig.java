package com.gmail.schcrabicus.prospring3.tutorials.ch8.jdbc.mappingSqlQuery;

import org.springframework.context.annotation.*;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

import javax.sql.DataSource;

/**
 * Created with IntelliJ IDEA.
 * User: schcrabicus
 * Date: 29.01.13
 * Time: 8:50
 * To change this template use File | Settings | File Templates.
 */
@Configuration
@ComponentScan(basePackages = "com.gmail.schcrabicus.prospring3.tutorials.ch8.jdbc.mappingSqlQuery")
@ImportResource(value = "classpath:com/gmail/schcrabicus/prospring3/tutorials/ch8/jdbc/mappingSqlQuery/config/spring-logging.xml")
public class AppConfig {

    @Bean
    public DataSource dataSource(){
        EmbeddedDatabaseBuilder builder = new EmbeddedDatabaseBuilder();
        EmbeddedDatabase database = builder.setType(EmbeddedDatabaseType.H2).
                addScript("classpath:com/gmail/schcrabicus/prospring3/tutorials/ch8/jdbc/mappingSqlQuery/config/schema.sql").
                addScript("classpath:com/gmail/schcrabicus/prospring3/tutorials/ch8/jdbc/mappingSqlQuery/config/test_data.sql").
                build();

        return database;
    }
}

package com.gmail.schcrabicus.prospring3.tutorials.ch8.jdbc.rowMapper;

import com.gmail.schcrabicus.prospring3.tutorials.ch8.jdbc.rowMapper.dao.IContactDao;
import com.gmail.schcrabicus.prospring3.tutorials.ch8.jdbc.rowMapper.dao.JdbcContactDao;
import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.Date;
import java.util.GregorianCalendar;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: schcrabicus
 * Date: 24.01.13
 * Time: 8:35
 * To change this template use File | Settings | File Templates.
 */
public class PlainJDBCSample {

    private static Logger log = Logger.getLogger(PlainJDBCSample.class);

    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:**/ch8/jdbc/rowMapper/config/spring-app-config.xml");

        IContactDao dao = context.getBean("jdbcContactDao", IContactDao.class);

        // Find and list all contacts
        List<Contact> contacts = dao.findAllWithDetail();
        listAllContacts(contacts);


    }

    private static void listAllContacts(List<Contact> contacts) {

        for (Contact contact: contacts) {
            log.info(contact);
            if (contact.getContactTelDetails() != null) {
                for (ContactTelDetail contactTelDetail:
                        contact.getContactTelDetails()) {
                    System.out.println("---" + contactTelDetail);
                }
            }
            log.info("");
        }
    }
}

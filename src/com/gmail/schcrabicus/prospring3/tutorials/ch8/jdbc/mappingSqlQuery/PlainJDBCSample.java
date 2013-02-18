package com.gmail.schcrabicus.prospring3.tutorials.ch8.jdbc.mappingSqlQuery;

import com.gmail.schcrabicus.prospring3.tutorials.ch8.jdbc.mappingSqlQuery.dao.IContactDao;
import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.Date;
import java.util.ArrayList;
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

        //ApplicationContext context = new ClassPathXmlApplicationContext("classpath:**/ch8/jdbc/mappingSqlQuery/config/spring-app-config.xml");
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        IContactDao dao = context.getBean("contactDao", IContactDao.class);

        // Find and list all contacts
        List<Contact> contacts = dao.findAll();
        listAllContacts(contacts);

        log.info(".....................................");
        log.info("Finding contacts by first name : ....");

        contacts = dao.findByFirstName("Kolya");
        listAllContacts(contacts);

        log.info(".....................................");
        log.info("Updating Vova .......................");
        Contact contact = dao.findByFirstName("Vova").get(0);
        contact.setFirstName("Vladimir");
        contact.setBirthDate(new Date(1989, 12, 05));
        dao.update(contact);

        // Find and list all contacts
        contacts = dao.findAll();
        listAllContacts(contacts);

        // Insert contact
        contact = new Contact();
        contact.setFirstName("Rod");
        contact.setLastName("Johnson");
        contact.setBirthDate(new Date((new GregorianCalendar(2001, 10,
                1)).getTime().getTime()));
        dao.create(contact);
        contacts = dao.findAll();
        listAllContacts(contacts);

        log.info(".....................................");
        log.info("Testing the insertWithDetail() Method .......................");
        log.info(".....................................");
        //Testing the insertWithDetail() Method
        // Insert contact with details
        contact = new Contact();
        contact.setFirstName("Michael");
        contact.setLastName("Jackson");
        contact.setBirthDate(new Date((new GregorianCalendar(1964, 10,
                1)).getTime().getTime()));
        List<ContactTelDetail> contactTelDetails = new ArrayList<ContactTelDetail>();
        ContactTelDetail contactTelDetail = new ContactTelDetail();
        contactTelDetail.setTelType("Home");
        contactTelDetail.setTelNumber("11111111");
        contactTelDetails.add(contactTelDetail);
        contactTelDetail = new ContactTelDetail();
        contactTelDetail.setTelType("Mobile");
        contactTelDetail.setTelNumber("22222222");
        contactTelDetails.add(contactTelDetail);
        contact.setContactTelDetails(contactTelDetails);
        dao.createWithDetail(contact);
        contacts = dao.findAllWithDetail();
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

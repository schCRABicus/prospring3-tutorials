package com.gmail.schcrabicus.prospring3.tutorials.ch13.transactions;

import com.gmail.schcrabicus.prospring3.tutorials.ch13.transactions.domain.Contact;
import com.gmail.schcrabicus.prospring3.tutorials.ch13.transactions.service.ContactService;
import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: schcrabicus
 * Date: 15.02.13
 * Time: 7:30
 * To change this template use File | Settings | File Templates.
 */
public class Launcher {

    private static Logger log = Logger.getLogger(Launcher.class);

    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:**/ch13/transactions/config/spring-app-config.xml");

        ContactService contactService = ctx.getBean("contactService", ContactService.class);
        List<Contact> contacts = contactService.findAll();
        for (Contact contactTemp: contacts) {
            log.info(contactTemp);
        }

        log.info("...reading and updating...");
        Contact contact = contactService.findById(1l);
        log.info(contact);
        contact.setFirstName("Peter");
        contactService.save(contact);
        log.info("Contact saved successfully");

        log.info("... Testing countAll() method ...");
        log.info("Contact count: " + contactService.countAll());
    }
}

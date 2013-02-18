package com.gmail.schcrabicus.prospring3.tutorials.ch10.jpa2.spring.data;

import com.gmail.schcrabicus.prospring3.tutorials.ch10.jpa2.spring.data.domain.Contact;
import com.gmail.schcrabicus.prospring3.tutorials.ch10.jpa2.spring.data.domain.ContactAudit;
import com.gmail.schcrabicus.prospring3.tutorials.ch10.jpa2.spring.data.domain.ContactTelDetail;
import com.gmail.schcrabicus.prospring3.tutorials.ch10.jpa2.spring.data.domain.Hobby;
import com.gmail.schcrabicus.prospring3.tutorials.ch10.jpa2.spring.data.services.ContactAuditService;
import com.gmail.schcrabicus.prospring3.tutorials.ch10.jpa2.spring.data.services.ContactService;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * User: schcrabicus
 * Date: 31.01.13
 * Time: 7:47
 * To change this template use File | Settings | File Templates.
 */
public class SpringJPASimple {

    private static Logger log = Logger.getLogger(SpringJPASimple.class);

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:**/ch10/jpa2/spring/data/config/spring-app-config.xml");

        //ContactService contactService = context.getBean("springJpaContactService", ContactService.class);

        /*// Find all contacts
        log.info("--------------Find all contacts------------");
        List<Contact> contacts = contactService.findAll();
        listContacts(contacts);
        log.info("-------------------------------------------");

        // Find contacts by first name
        log.info("--------------Find contacts by first name------------");
        contacts = contactService.findByFirstName("Clarence");
        listContacts(contacts);
        log.info("-------------------------------------------");

        // Find contacts by first name and last name
        log.info("--------------Find contacts by first name and last name------------");
        contacts = contactService.findByFirstNameAndLastName("Clarence", "Ho");
        listContacts(contacts);
        log.info("-------------------------------------------");*/

        ContactAuditService contactService = context.getBean(
                "springJpaContactAuditService", ContactAuditService.class);
        log.info("--------------Find All------------");
        List<ContactAudit> contacts = contactService.findAll();
        listContactsAudit(contacts);
        log.info("-------------------------------------------");

        // Add new contact
        log.info("--------------Add new contact------------");
        ContactAudit contact = new ContactAudit();
        contact.setFirstName("Michael");
        contact.setLastName("Jackson");
        contact.setBirthDate(new Date());
        contactService.save(contact);
        contacts = contactService.findAll();
        listContactsAudit(contacts);
        log.info("-------------------------------------------");

        // Find by id
        log.info("--------------Find by id------------");
        contact = contactService.findById(1l);
        log.info("");
        log.info("Contact with id 1:" + contact);
        log.info("");
        log.info("-------------------------------------------");

        // Update contact
        log.info("--------------Update contact------------");
        contact.setFirstName("Tom");
        contactService.save(contact);
        contacts = contactService.findAll();
        listContactsAudit(contacts);
        log.info("-------------------------------------------");

    }

    private static void listContacts(List<Contact> contacts) {
        log.info("");
        log.info("Listing contacts without details:");
        for (Contact contact: contacts) {
            log.info(contact);
            log.info("");
        }
    }

    private static void listContactsAudit(List<ContactAudit> contacts) {
        log.info("");
        log.info("Listing contacts without details:");
        for (ContactAudit contact: contacts) {
            log.info(contact);
            log.info("");
        }
    }

    private static void listContactsWithDetail(List<Contact> contacts) {
        log.info("");
        log.info("Listing contacts with details:");
        for (Contact contact: contacts) {
            log.info(contact);
            if (contact.getContactTelDetails() != null) {
                for (ContactTelDetail contactTelDetail:
                        contact.getContactTelDetails()) {
                    log.info(contactTelDetail);
                }
            }
            if (contact.getHobbies() != null) {
                for (Hobby hobby: contact.getHobbies()) {
                    log.info(hobby);
                }
            }
            log.info("");
        }
    }
}

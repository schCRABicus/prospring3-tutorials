package com.gmail.schcrabicus.prospring3.tutorials.ch11.mybatis;

import com.gmail.schcrabicus.prospring3.tutorials.ch11.mybatis.domain.Contact;
import com.gmail.schcrabicus.prospring3.tutorials.ch11.mybatis.domain.ContactTelDetail;
import com.gmail.schcrabicus.prospring3.tutorials.ch11.mybatis.domain.Hobby;
import com.gmail.schcrabicus.prospring3.tutorials.ch11.mybatis.service.ContactService;
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
public class MyBatisSample {

    private static Logger log = Logger.getLogger(MyBatisSample.class);

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:**/ch11/mybatis/config/spring-app-config.xml");

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

        ContactService contactService = context.getBean(
                "contactService", ContactService.class);
       /* log.info("--------------Find All------------");
        List<Contact> contacts = contactService.findAll();
        listContacts(contacts);
        log.info("-------------------------------------------");*/

        log.info("--------------Find All With Detail------------");
        List<Contact> contacts = contactService.findAllWithDetail();
        listContactsWithDetail(contacts);
        log.info("-------------------------------------------");

        // Find by id
        log.info("--------------Find by id------------");
        Contact contact = contactService.findById(1l);
        log.info("");
        log.info("Contact with id 1:" + contact);
        log.info("");
        log.info("-------------------------------------------");

        // Find contact by first name and last name
        log.info("--------------Find contact by first name and last name------------");
        contacts = contactService.findByFirstNameAndLastName("Clarence", "Ho");
        listContactsWithDetail(contacts);
        log.info("-------------------------------------------");

        // Add new contact
        log.info("--------------Add new contact--------------");
        contact = new Contact();
        contact.setFirstName("Kolya");
        contact.setLastName("Luschicky");
        contact.setBirthDate(new Date());
        Set<ContactTelDetail> contactTelDetails = new HashSet<ContactTelDetail>();
        ContactTelDetail contactTelDetail = new ContactTelDetail();
        contactTelDetail.setTelType("Home");
        contactTelDetail.setTelNumber("111111");
        contactTelDetails.add(contactTelDetail);
        contactTelDetail = new ContactTelDetail();
        contactTelDetail.setTelType("Mobile");
        contactTelDetail.setTelNumber("222222");
        contactTelDetails.add(contactTelDetail);
        contact.setContactTelDetails(contactTelDetails);
        Set<Hobby> hobbies = new HashSet<Hobby>();
        Hobby hobby = new Hobby();
        hobby.setHobbyId("Jogging");
        hobbies.add(hobby);
        hobby = new Hobby();
        hobby.setHobbyId("Basketball");
        hobbies.add(hobby);
        contact.setHobbies(hobbies);
        contactService.save(contact);
        contacts = contactService.findAllWithDetail();
        listContactsWithDetail(contacts);
        log.info("-------------------------------------------");

        // Update contact
        log.info("-------------- Update contact with id 1 --------------");
        contact = contactService.findById(1l);
        contact.setFirstName("Kim Fung");
        Set<ContactTelDetail> contactTels = contact.getContactTelDetails();
        ContactTelDetail toDeleteContactTel = null;
        for (ContactTelDetail contactTel: contactTels) {
            if (contactTel.getTelType().equals("Home")) {
                toDeleteContactTel = contactTel;
            }
        }
        contactTels.remove(toDeleteContactTel);
        hobby = new Hobby();
        hobby.setHobbyId("Jogging");
        contact.getHobbies().add(hobby);
        contactService.update(contact);
        contacts = contactService.findAllWithDetail();
        listContactsWithDetail(contacts);
        log.info("-------------------------------------------");

        // Delete contact
        log.info("-------------- Delete contact with id 1 --------------");
        contact = contactService.findById(1l);
        contactService.delete(contact);
        contacts = contactService.findAllWithDetail();
        listContactsWithDetail(contacts);
        log.info("-------------------------------------------");
        /*// Add new contact
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


        // Find audit record by revision
        log.info("--------------Find audit record by revision------------");
        ContactAudit oldContact = contactService.findAuditByRevision(1l, 1);
        log.info("");
        log.info("Old Contact with id 1 and rev 1:" + oldContact);
        log.info("");
        oldContact = contactService.findAuditByRevision(1l, 2);
        log.info("");
        log.info("Old Contact with id 1 and rev 2:" + oldContact);
        log.info("");*/

    }

    private static void listContacts(List<Contact> contacts) {
        log.info("");
        log.info("Listing contacts without details:");
        for (Contact contact: contacts) {
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

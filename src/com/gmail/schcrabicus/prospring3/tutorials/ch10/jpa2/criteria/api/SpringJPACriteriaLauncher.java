package com.gmail.schcrabicus.prospring3.tutorials.ch10.jpa2.criteria.api;

import com.gmail.schcrabicus.prospring3.tutorials.ch9.hibernate.simple.dao.IContactDao;
import com.gmail.schcrabicus.prospring3.tutorials.ch9.hibernate.simple.domain.Contact;
import com.gmail.schcrabicus.prospring3.tutorials.ch9.hibernate.simple.domain.ContactTelDetail;
import com.gmail.schcrabicus.prospring3.tutorials.ch9.hibernate.simple.domain.Hobby;
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
public class SpringJPACriteriaLauncher {

    private static Logger log = Logger.getLogger(SpringJPACriteriaLauncher.class);

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:**/ch9/hibernate/simple/configs/spring-app-config.xml");

        IContactDao dao = context.getBean("contactDao", IContactDao.class);
        List<Contact> contacts = dao.findAll();
        //listContacts(contacts);
        listContactsWithDetail(contacts);

        log.info("---------------------");
        log.info("---------------------");
        log.info("-----findAllWithDetail-----");
        contacts = dao.findAllWithDetail();
        listContactsWithDetail(contacts);

        log.info("---------------------");
        log.info("---------------------");
        log.info("-----findById-----");
        Contact contact = dao.findById(1l);
        log.info(contact);

        log.info("---------------------");
        log.info("---------------------");
        log.info("-----Add new contact-----");
        contact = new Contact();
        contact.setFirstName("Michael");
        contact.setLastName("Jackson");
        contact.setBirthDate(new Date());
        contact.setContactTelDetails(new HashSet<ContactTelDetail>());
        ContactTelDetail contactTelDetail = new ContactTelDetail("Home", "1111111111");
        contact.getContactTelDetails().add(contactTelDetail);
        contactTelDetail.setContact(contact);
        contactTelDetail = new ContactTelDetail("Mobile", "2222222222");
        contact.getContactTelDetails().add(contactTelDetail);
        contactTelDetail.setContact(contact);
        dao.save(contact);
        contacts = dao.findAllWithDetail();
        listContactsWithDetail(contacts);

        log.info("---------------------");
        log.info("---------------------");
        log.info("-----Update contact-----");
        contact = dao.findById(1l);
        contact.setFirstName("Kim Fung");
        Set<ContactTelDetail> contactTels = contact.getContactTelDetails();
        ContactTelDetail toDeleteContactTel = null;
        for (ContactTelDetail contactTel: contactTels) {
            if (contactTel.getTelType().equals("Home")) {
                toDeleteContactTel = contactTel;
            }
        }
        //log.info(" >> toDeleteContactTel : " + toDeleteContactTel);
        //contact.getContactTelDetails().remove(toDeleteContactTel);
        //log.info(" >> contactTels.remove(toDeleteContactTel) : " + contactTels.remove(toDeleteContactTel));
        contact.getContactTelDetails().remove(toDeleteContactTel);
        //log.info(" >> ContactTelDetails : " + contact.getContactTelDetails());
        dao.save(contact);
        contacts = dao.findAllWithDetail();
        listContactsWithDetail(contacts);

        log.info("---------------------");
        log.info("---------------------");
        log.info("-----Delete contact-----");
        contact = dao.findById(1l);
        dao.delete(contact);
        contacts = dao.findAllWithDetail();
        listContactsWithDetail(contacts);
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

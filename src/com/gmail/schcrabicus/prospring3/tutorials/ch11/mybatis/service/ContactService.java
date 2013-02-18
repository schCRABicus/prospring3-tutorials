package com.gmail.schcrabicus.prospring3.tutorials.ch11.mybatis.service;

import com.gmail.schcrabicus.prospring3.tutorials.ch11.mybatis.domain.Contact;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: schcrabicus
 * Date: 08.02.13
 * Time: 7:54
 * To change this template use File | Settings | File Templates.
 */
public interface ContactService {

    // Find all contacts - without details
    public List<Contact> findAll();
    // Find all contacts - with tels and hobbies
    public List<Contact> findAllWithDetail();
    // Find by ID - with tels and hobbies
    public Contact findById(Long id);
    // Create a new or save an existing contact
    public Contact save(Contact contact);
    // Delete a contact
    public void delete(Contact contact);

    public void update(Contact contact);
    // Find a contact by first name and last name
    public List<Contact> findByFirstNameAndLastName(String firstName, String lastName);
}

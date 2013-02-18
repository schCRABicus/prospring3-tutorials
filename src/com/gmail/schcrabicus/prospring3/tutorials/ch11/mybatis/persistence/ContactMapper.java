package com.gmail.schcrabicus.prospring3.tutorials.ch11.mybatis.persistence;

import com.gmail.schcrabicus.prospring3.tutorials.ch11.mybatis.domain.Contact;
import com.gmail.schcrabicus.prospring3.tutorials.ch11.mybatis.domain.SearchCriteria;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: schcrabicus
 * Date: 11.02.13
 * Time: 7:20
 * To change this template use File | Settings | File Templates.
 */
public interface ContactMapper {

    // Find all contacts - without details
    public List<Contact> findAll();
    // Find all contacts - with tels and hobbies
    public List<Contact> findAllWithDetail();
    // Find by ID - with tels and hobbies
    public Contact findById(Long id);
    // Create a new or save an existing contact
    public void save(Contact contact);

    public void update(Contact contact);
    // Delete a contact
    public void delete(Contact contact);
    // Find a contact by first name and last name
    public List<Contact> findByFirstNameAndLastName(SearchCriteria criteria);

}

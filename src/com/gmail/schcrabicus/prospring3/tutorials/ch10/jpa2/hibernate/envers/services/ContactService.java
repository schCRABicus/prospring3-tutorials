package com.gmail.schcrabicus.prospring3.tutorials.ch10.jpa2.hibernate.envers.services;

import com.gmail.schcrabicus.prospring3.tutorials.ch10.jpa2.hibernate.envers.domain.Contact;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: schcrabicus
 * Date: 05.02.13
 * Time: 7:24
 * To change this template use File | Settings | File Templates.
 */
public interface ContactService {

    public List<Contact> findAll();

    // Find contacts by first name
    public List<Contact> findByFirstName(String firstName);

    // Find contacts by first name and last name
    public List<Contact> findByFirstNameAndLastName(String firstName, String lastName);
}

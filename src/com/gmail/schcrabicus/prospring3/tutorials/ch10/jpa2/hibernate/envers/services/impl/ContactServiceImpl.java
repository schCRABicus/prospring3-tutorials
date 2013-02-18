package com.gmail.schcrabicus.prospring3.tutorials.ch10.jpa2.hibernate.envers.services.impl;

import com.gmail.schcrabicus.prospring3.tutorials.ch10.jpa2.hibernate.envers.domain.Contact;
import com.gmail.schcrabicus.prospring3.tutorials.ch10.jpa2.hibernate.envers.repository.ContactRepository;
import com.gmail.schcrabicus.prospring3.tutorials.ch10.jpa2.hibernate.envers.services.ContactService;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: schcrabicus
 * Date: 05.02.13
 * Time: 7:42
 * To change this template use File | Settings | File Templates.
 */
@Service("springJpaContactService")
@Repository
@Transactional
public class ContactServiceImpl implements ContactService {

    @Autowired
    private ContactRepository contactRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Contact> findAll() {
        return Lists.newArrayList(contactRepository.findAll());
    }

    @Override
    @Transactional(readOnly = true)
    public List<Contact> findByFirstName(String firstName) {
        return contactRepository.findByFirstName(firstName);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Contact> findByFirstNameAndLastName(String firstName, String lastName) {
        return contactRepository.findByFirstNameAndLastName(firstName, lastName);
    }
}

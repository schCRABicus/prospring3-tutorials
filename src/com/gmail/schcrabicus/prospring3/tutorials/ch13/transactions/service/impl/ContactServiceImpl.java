package com.gmail.schcrabicus.prospring3.tutorials.ch13.transactions.service.impl;

import com.gmail.schcrabicus.prospring3.tutorials.ch13.transactions.domain.Contact;
import com.gmail.schcrabicus.prospring3.tutorials.ch13.transactions.repository.ContactRepository;
import com.gmail.schcrabicus.prospring3.tutorials.ch13.transactions.service.ContactService;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: schcrabicus
 * Date: 18.02.13
 * Time: 7:51
 * To change this template use File | Settings | File Templates.
 */
@Service("contactService")
@Repository
@Transactional
public class ContactServiceImpl implements ContactService {

    @Autowired
    private ContactRepository contactRepository;

    @Override
    @Transactional( readOnly = true )
    public List<Contact> findAll() {
        return Lists.newArrayList(contactRepository.findAll());
    }

    @Override
    @Transactional( readOnly = true , isolation = Isolation.REPEATABLE_READ , propagation = Propagation.REQUIRED)
    public Contact findById(Long id) {
        return contactRepository.findOne(id);
    }

    @Override
    public Contact save(Contact contact) {
        return contactRepository.save(contact);
    }

    @Override
    @Transactional( propagation = Propagation.NEVER )
    public long countAll() {
        return contactRepository.countAllContacts();
    }
}

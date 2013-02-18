package com.gmail.schcrabicus.prospring3.tutorials.ch13.transactions.service;

import com.gmail.schcrabicus.prospring3.tutorials.ch13.transactions.domain.Contact;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: schcrabicus
 * Date: 18.02.13
 * Time: 7:42
 * To change this template use File | Settings | File Templates.
 */

public interface ContactService {

    public List<Contact> findAll();

    public Contact findById(Long id);

    public Contact save(Contact contact);

    public long countAll();

}

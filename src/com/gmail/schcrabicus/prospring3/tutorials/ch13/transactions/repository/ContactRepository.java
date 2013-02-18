package com.gmail.schcrabicus.prospring3.tutorials.ch13.transactions.repository;

import com.gmail.schcrabicus.prospring3.tutorials.ch13.transactions.domain.Contact;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

/**
 * Created with IntelliJ IDEA.
 * User: schcrabicus
 * Date: 18.02.13
 * Time: 7:41
 * To change this template use File | Settings | File Templates.
 */
public interface ContactRepository extends CrudRepository<Contact, Long> {

    @Query("select count(c) from Contact c")
    public Long countAllContacts();

}

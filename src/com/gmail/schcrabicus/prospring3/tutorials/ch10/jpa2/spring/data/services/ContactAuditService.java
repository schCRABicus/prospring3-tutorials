package com.gmail.schcrabicus.prospring3.tutorials.ch10.jpa2.spring.data.services;

import com.gmail.schcrabicus.prospring3.tutorials.ch10.jpa2.spring.data.domain.ContactAudit;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: schcrabicus
 * Date: 05.02.13
 * Time: 8:39
 * To change this template use File | Settings | File Templates.
 */
public interface ContactAuditService {

    public List<ContactAudit> findAll();
    public ContactAudit findById(Long id);
    public ContactAudit save(ContactAudit contact);

}

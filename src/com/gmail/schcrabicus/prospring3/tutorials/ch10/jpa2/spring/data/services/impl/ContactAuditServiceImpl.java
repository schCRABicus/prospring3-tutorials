package com.gmail.schcrabicus.prospring3.tutorials.ch10.jpa2.spring.data.services.impl;

import com.gmail.schcrabicus.prospring3.tutorials.ch10.jpa2.spring.data.domain.ContactAudit;
import com.gmail.schcrabicus.prospring3.tutorials.ch10.jpa2.spring.data.repository.ContactAuditRepository;
import com.gmail.schcrabicus.prospring3.tutorials.ch10.jpa2.spring.data.services.ContactAuditService;
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
 * Time: 8:40
 * To change this template use File | Settings | File Templates.
 */
@Service("springJpaContactAuditService")
@Repository
@Transactional
public class ContactAuditServiceImpl implements ContactAuditService{

    @Autowired
    private ContactAuditRepository contactAuditRepository;

    @Override
    @Transactional(readOnly = true)
    public List<ContactAudit> findAll() {
        return Lists.newArrayList(contactAuditRepository.findAll());
    }

    @Override
    @Transactional(readOnly = true)
    public ContactAudit findById(Long id) {
        return contactAuditRepository.findOne(id);
    }

    @Override
    public ContactAudit save(ContactAudit contact) {
        return contactAuditRepository.save(contact);
    }
}

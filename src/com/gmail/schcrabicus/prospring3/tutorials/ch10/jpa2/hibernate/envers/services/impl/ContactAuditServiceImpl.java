package com.gmail.schcrabicus.prospring3.tutorials.ch10.jpa2.hibernate.envers.services.impl;

import com.gmail.schcrabicus.prospring3.tutorials.ch10.jpa2.hibernate.envers.domain.ContactAudit;
import com.gmail.schcrabicus.prospring3.tutorials.ch10.jpa2.hibernate.envers.repository.ContactAuditRepository;
import com.gmail.schcrabicus.prospring3.tutorials.ch10.jpa2.hibernate.envers.services.ContactAuditService;
import com.google.common.collect.Lists;
import org.hibernate.envers.AuditReader;
import org.hibernate.envers.AuditReaderFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
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
public class ContactAuditServiceImpl implements ContactAuditService {

    @Autowired
    private ContactAuditRepository contactAuditRepository;

    @PersistenceContext
    private EntityManager entityManager;

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

    @Override
    @Transactional(readOnly = true)
    public ContactAudit findAuditByRevision(Long id, int revision) {
        AuditReader auditReader = AuditReaderFactory.get(entityManager);
        return auditReader.find(ContactAudit.class, id, revision);
    }
}

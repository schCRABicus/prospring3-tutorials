package com.gmail.schcrabicus.prospring3.tutorials.ch10.jpa2.hibernate.envers.repository;

import com.gmail.schcrabicus.prospring3.tutorials.ch10.jpa2.hibernate.envers.domain.ContactAudit;
import org.springframework.data.repository.CrudRepository;

/**
 * Created with IntelliJ IDEA.
 * User: schcrabicus
 * Date: 05.02.13
 * Time: 8:39
 * To change this template use File | Settings | File Templates.
 */
public interface ContactAuditRepository extends CrudRepository<ContactAudit, Long> {

}

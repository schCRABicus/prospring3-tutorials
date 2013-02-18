package com.gmail.schcrabicus.prospring3.tutorials.ch9.hibernate.simple.dao.impl.hibernate;

import com.gmail.schcrabicus.prospring3.tutorials.ch9.hibernate.simple.dao.IContactDao;
import com.gmail.schcrabicus.prospring3.tutorials.ch9.hibernate.simple.domain.Contact;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: schcrabicus
 * Date: 31.01.13
 * Time: 7:42
 * To change this template use File | Settings | File Templates.
 */
@Component
@Repository("contactDao")
@Transactional
public class ContactDao extends HibernateDao<Contact> implements IContactDao {

    @Autowired
    private SessionFactory sessionFactory;

    public ContactDao(){
        super(Contact.class);
    }

    @Override
    public List<Contact> findAllWithDetail() {
        return (List<Contact>)sessionFactory
                .getCurrentSession()
                .getNamedQuery("Contact.findAllWithDetail")
                .list();
    }

    @Override
    public Contact findById(Long id) {
        return (Contact)sessionFactory
                .getCurrentSession()
                .getNamedQuery("Contact.findById")
                .setLong("id", id)
                .uniqueResult();
    }
}

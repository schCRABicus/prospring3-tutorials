package com.gmail.schcrabicus.prospring3.tutorials.ch9.hibernate.simple.dao.impl.hibernate;

import com.gmail.schcrabicus.prospring3.tutorials.ch9.hibernate.simple.dao.IDao;
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
 * Time: 7:36
 * To change this template use File | Settings | File Templates.
 */
@Transactional
public class HibernateDao<T> implements IDao<T> {

    @Autowired
    private SessionFactory sessionFactory;

    private Class aClass;

    public HibernateDao(Class aClass){
        this.aClass = aClass;
    }

    @Override
    @Transactional(readOnly = true)
    public List<T> findAll() {
        return (List<T>)sessionFactory
                .getCurrentSession()
                .createCriteria(aClass.getCanonicalName())
                .list();
    }

    @Override
    public List<T> findAllWithDetail() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public T findById(Long id) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public T save(T object) {
        sessionFactory
                .getCurrentSession()
                .saveOrUpdate(object);

        return object;
    }

    @Override
    public void delete(T object) {
        sessionFactory
                .getCurrentSession()
                .delete(object);
    }
}

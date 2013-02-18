package com.gmail.schcrabicus.prospring3.tutorials.ch8.jdbc.spring.basic.dao;

import com.gmail.schcrabicus.prospring3.tutorials.ch8.jdbc.rowMapper.Contact;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: schcrabicus
 * Date: 24.01.13
 * Time: 7:56
 * To change this template use File | Settings | File Templates.
 */
public interface IContactDao extends IDao<Contact> {

    public List<Contact> findByFirstName(String firstName);

    public String findFirstNameById(Long id);

    public String findLastNameById(Long id);

}

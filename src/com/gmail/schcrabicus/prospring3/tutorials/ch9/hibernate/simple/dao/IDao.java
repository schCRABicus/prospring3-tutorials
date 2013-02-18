package com.gmail.schcrabicus.prospring3.tutorials.ch9.hibernate.simple.dao;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: schcrabicus
 * Date: 30.01.13
 * Time: 8:31
 * To change this template use File | Settings | File Templates.
 */
public interface IDao<T> {

    public List<T> findAll();

    // Find all contacts with telephone and hobbies
    public List<T> findAllWithDetail();

    public T findById(Long id);

    // Insert or update a contact
    public T save(T object);

    // Delete a contact
    public void delete(T object);
}

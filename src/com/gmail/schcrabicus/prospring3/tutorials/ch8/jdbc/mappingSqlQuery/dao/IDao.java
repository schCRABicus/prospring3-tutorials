package com.gmail.schcrabicus.prospring3.tutorials.ch8.jdbc.mappingSqlQuery.dao;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: schcrabicus
 * Date: 24.01.13
 * Time: 7:54
 * To change this template use File | Settings | File Templates.
 */
public interface IDao<T> {

    public List<T> findAll();

    public void create(T object);

    public void createWithDetail(T object);

    public void delete(T object);

    public void update(T object);
}

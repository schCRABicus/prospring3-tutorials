package com.gmail.schcrabicus.prospring3.tutorials.ch11.mybatis.persistence;

import com.gmail.schcrabicus.prospring3.tutorials.ch11.mybatis.domain.Hobby;

/**
 * Created with IntelliJ IDEA.
 * User: schcrabicus
 * Date: 14.02.13
 * Time: 7:30
 * To change this template use File | Settings | File Templates.
 */
public interface HobbyMapper {

    public void saveOrUpdate(Hobby hobby);

    public boolean exists(Hobby hobby);
}

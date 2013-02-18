package com.gmail.schcrabicus.prospring3.tutorials.ch11.mybatis.persistence;

import com.gmail.schcrabicus.prospring3.tutorials.ch11.mybatis.domain.Hobby;

/**
 * Created with IntelliJ IDEA.
 * User: schcrabicus
 * Date: 12.02.13
 * Time: 7:25
 * To change this template use File | Settings | File Templates.
 */
public interface ContactHobbyDetailMapper {

    public void save(Hobby hobby);

    public void deleteHobbyDetailForContact(Long contactId);
}

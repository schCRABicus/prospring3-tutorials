package com.gmail.schcrabicus.prospring3.tutorials.ch11.mybatis.persistence;

import com.gmail.schcrabicus.prospring3.tutorials.ch11.mybatis.domain.ContactTelDetail;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: schcrabicus
 * Date: 12.02.13
 * Time: 7:21
 * To change this template use File | Settings | File Templates.
 */
public interface ContactTelDetailMapper {

    public void save(ContactTelDetail contactTelDetail);

    public void updateContactTelDetail(ContactTelDetail contactTelDetail);

    public void deleteOrphanContactTelDetail(List<Long> ids);

    public List<ContactTelDetail> selectTelDetailForContact(Long contactId);

    public void deleteTelDetailForContact(Long contactId);
}

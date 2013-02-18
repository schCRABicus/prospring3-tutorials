package com.gmail.schcrabicus.prospring3.tutorials.ch11.mybatis.domain;

import com.sun.istack.internal.NotNull;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * User: schcrabicus
 * Date: 30.01.13
 * Time: 8:04
 * To change this template use File | Settings | File Templates.
 */

public class ContactTelDetail implements Serializable {

    private Long id;

    private String telType;

    private String telNumber;

    private Contact contact;

    public ContactTelDetail(){

    }

    public ContactTelDetail(String telType, String telNumber){
        this.telType = telType;
        this.telNumber = telNumber;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTelType() {
        return telType;
    }

    public void setTelType(String telType) {
        this.telType = telType;
    }

    public String getTelNumber() {
        return telNumber;
    }

    public void setTelNumber(String telNumber) {
        this.telNumber = telNumber;
    }

    public Contact getContact() {
        return contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ContactTelDetail that = (ContactTelDetail) o;

        //if (contact != null ? !contact.equals(that.contact) : that.contact != null) return false;
        if (telNumber != null ? !telNumber.equals(that.telNumber) : that.telNumber != null) return false;
        if (telType != null ? !telType.equals(that.telType) : that.telType != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = 1;
        result = 31 * result + (telType != null ? telType.hashCode() : 0);
        result = 31 * result + (telNumber != null ? telNumber.hashCode() : 0);
        //result = 31 * result + (contact != null ? contact.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "ContactTelDetail{" +
                "id=" + id +
                ", telType='" + telType + '\'' +
                ", telNumber='" + telNumber + '\'' +
                ", contact=" + contact +
                '}';
    }
}

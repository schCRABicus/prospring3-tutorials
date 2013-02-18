package com.gmail.schcrabicus.prospring3.tutorials.ch8.jdbc.mappingSqlQuery;

import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * User: schcrabicus
 * Date: 24.01.13
 * Time: 7:49
 * To change this template use File | Settings | File Templates.
 */
public class ContactTelDetail implements Serializable {

    private long id;

    private Long contactId;

    private String telType;

    private String telNumber;

    public Long getContactId() {
        return contactId;
    }

    public void setContactId(Long contactId) {
        this.contactId = contactId;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ContactTelDetail that = (ContactTelDetail) o;

        if (!telNumber.equals(that.telNumber)) return false;
        if (!telType.equals(that.telType)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = telType.hashCode();
        result = 31 * result + telNumber.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "ContactTelDetail{" +
                "id=" + id +
                ", telType='" + telType + '\'' +
                ", telNumber='" + telNumber + '\'' +
                '}';
    }
}

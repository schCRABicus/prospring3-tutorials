package com.gmail.schcrabicus.prospring3.tutorials.ch11.mybatis.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * User: schcrabicus
 * Date: 30.01.13
 * Time: 8:18
 * To change this template use File | Settings | File Templates.
 */

public class Hobby implements Serializable {


    private String hobbyId;

    private Set<Contact> contacts = new HashSet<Contact>();

    public String getHobbyId() {
        return hobbyId;
    }

    public void setHobbyId(String hobbyId) {
        this.hobbyId = hobbyId;
    }

    public Set<Contact> getContacts() {
        return contacts;
    }

    public void setContacts(Set<Contact> contacts) {
        this.contacts = contacts;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Hobby hobby = (Hobby) o;

        if (contacts != null ? !contacts.equals(hobby.contacts) : hobby.contacts != null) return false;
        if (!hobbyId.equals(hobby.hobbyId)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = hobbyId.hashCode();
        result = 31 * result + (contacts != null ? contacts.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Hobby{" +
                "hobbyId='" + hobbyId + '\'' +
                ", contacts=" + contacts +
                '}';
    }
}

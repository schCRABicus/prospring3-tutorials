package com.gmail.schcrabicus.prospring3.tutorials.ch5.lifecycle.propertyEditors.custom;

/**
 * Created with IntelliJ IDEA.
 * User: schcrabicus
 * Date: 13.01.13
 * Time: 8:24
 * To change this template use File | Settings | File Templates.
 */
public class Name {

    private String firstName;

    private String lastName;

    public Name(){

    }

    public Name(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "Name{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}

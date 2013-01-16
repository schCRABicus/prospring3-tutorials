package com.gmail.schcrabicus.prospring3.tutorials.ch6.aop.advice.before.secure;

/**
 * Created with IntelliJ IDEA.
 * User: schcrabicus
 * Date: 15.01.13
 * Time: 8:18
 * To change this template use File | Settings | File Templates.
 */
public class UserInfo {

    private String firstName;
    private String lastName;

    public UserInfo(String firstName, String lastName){
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    @Override
    public String toString() {
        return "UserInfo{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}

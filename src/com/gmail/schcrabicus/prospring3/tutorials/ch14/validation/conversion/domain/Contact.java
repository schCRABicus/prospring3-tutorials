package com.gmail.schcrabicus.prospring3.tutorials.ch14.validation.conversion.domain;

import org.joda.time.DateTime;

import java.net.URL;

/**
 * Created with IntelliJ IDEA.
 * User: schcrabicus
 * Date: 19.02.13
 * Time: 7:23
 * To change this template use File | Settings | File Templates.
 */
public class Contact {

    private String firstName;
    private String lastName;
    private DateTime birthDate;
    private URL personalSite;

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

    public DateTime getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(DateTime birthDate) {
        this.birthDate = birthDate;
    }

    public URL getPersonalSite() {
        return personalSite;
    }

    public void setPersonalSite(URL personalSite) {
        this.personalSite = personalSite;
    }

    @Override
    public String toString() {
        return "Contact{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", birthDate=" + birthDate +
                ", personalSite=" + personalSite +
                '}';
    }
}

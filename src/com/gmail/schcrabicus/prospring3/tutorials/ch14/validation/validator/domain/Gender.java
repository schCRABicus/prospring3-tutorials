package com.gmail.schcrabicus.prospring3.tutorials.ch14.validation.validator.domain;

/**
 * Created with IntelliJ IDEA.
 * User: schcrabicus
 * Date: 20.02.13
 * Time: 7:58
 * To change this template use File | Settings | File Templates.
 */
public enum Gender {

    MALE("M"), FEMALE("F");

    private String code;

    private Gender(String code){
        this.code = code;
    }

    public String toString() {
        return this.code;
    }
}

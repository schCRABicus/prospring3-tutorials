package com.gmail.schcrabicus.prospring3.tutorials.ch4.lazyinit;

/**
 * Created with IntelliJ IDEA.
 * User: schcrabicus
 * Date: 08.01.13
 * Time: 8:15
 * To change this template use File | Settings | File Templates.
 */
public class RegularBean {

    private String value;

    public RegularBean(String value){
        System.out.println("initializing regular bean...");
        this.value = value;
    }

    @Override
    public String toString() {
        return "RegularBean{" +
                "value='" + value + '\'' +
                '}';
    }
}

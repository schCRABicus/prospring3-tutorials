package com.gmail.schcrabicus.prospring3.tutorials.ch4.lazyinit;

/**
 * Created with IntelliJ IDEA.
 * User: schcrabicus
 * Date: 08.01.13
 * Time: 8:17
 * To change this template use File | Settings | File Templates.
 */
public class LazyInitBean {

    private String value;

    public LazyInitBean(String value){
        System.out.println("Initializing lazy init bean...");
        this.value = value;
    }

    @Override
    public String toString() {
        return "LazyInitBean{" +
                "value='" + value + '\'' +
                '}';
    }
}

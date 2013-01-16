package com.gmail.schcrabicus.prospring3.tutorials.ch6.aop.advice.throwz;

/**
 * Created with IntelliJ IDEA.
 * User: schcrabicus
 * Date: 16.01.13
 * Time: 8:37
 * To change this template use File | Settings | File Templates.
 */
public class ErrorBean {

    public void errorProneMethod() throws Exception {
        throw new Exception("Foo");
    }

    public void otherErrorProneMethod() throws IllegalArgumentException {
        throw new IllegalArgumentException("Bar");
    }
}

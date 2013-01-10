package com.gmail.schcrabicus.prospring3.tutorials.ch4.simple.injection.xml;

/**
 * Created with IntelliJ IDEA.
 * User: schcrabicus
 * Date: 02.01.13
 * Time: 8:36
 * To change this template use File | Settings | File Templates.
 */
public class HelloWorldMessageProvider implements MessageProvider {

    @Override
    public String getMessage() {
        return "Hello World!";
    }
}

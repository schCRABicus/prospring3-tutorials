package com.gmail.schcrabicus.prospring3.tutorials.ch4.injection.annotation.resource;

import org.springframework.stereotype.Service;

/**
 * Created with IntelliJ IDEA.
 * User: schcrabicus
 * Date: 02.01.13
 * Time: 8:36
 * To change this template use File | Settings | File Templates.
 */
@Service("messageProvider")
public class HelloWorldMessageProvider implements MessageProvider {

    @Override
    public String getMessage() {
        return "Hello World!";
    }
}

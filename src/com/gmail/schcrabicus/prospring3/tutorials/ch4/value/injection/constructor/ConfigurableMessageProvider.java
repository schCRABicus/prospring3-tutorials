package com.gmail.schcrabicus.prospring3.tutorials.ch4.value.injection.constructor;

/**
 * Created with IntelliJ IDEA.
 * User: schcrabicus
 * Date: 02.01.13
 * Time: 8:36
 * To change this template use File | Settings | File Templates.
 */
public class ConfigurableMessageProvider implements MessageProvider {

    private String message;

    public ConfigurableMessageProvider(String message){
        this.message = message;
    }

    @Override
    public String getMessage() {
        return this.message;
    }
}

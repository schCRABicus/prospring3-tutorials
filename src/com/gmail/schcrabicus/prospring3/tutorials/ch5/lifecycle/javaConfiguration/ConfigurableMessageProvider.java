package com.gmail.schcrabicus.prospring3.tutorials.ch5.lifecycle.javaConfiguration;

/**
 * Created with IntelliJ IDEA.
 * User: schcrabicus
 * Date: 14.01.13
 * Time: 7:37
 * To change this template use File | Settings | File Templates.
 */
public class ConfigurableMessageProvider implements MessageProvider {

    private String message = "default message";

    public ConfigurableMessageProvider(){

    }

    public ConfigurableMessageProvider(String message){
        this.message = message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }
}

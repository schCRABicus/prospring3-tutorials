package com.gmail.schcrabicus.prospring3.tutorials.ch5.lifecycle.javaConfiguration;

/**
 * Created with IntelliJ IDEA.
 * User: schcrabicus
 * Date: 14.01.13
 * Time: 7:39
 * To change this template use File | Settings | File Templates.
 */
public interface MessageRenderer {

    public void render();

    public void setMessageProvider(MessageProvider messageProvider);

    public MessageProvider getMessageProvider();
}

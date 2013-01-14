package com.gmail.schcrabicus.prospring3.tutorials.ch5.lifecycle.eventListeners;

import org.springframework.context.ApplicationEvent;

/**
 * Created with IntelliJ IDEA.
 * User: schcrabicus
 * Date: 13.01.13
 * Time: 9:07
 * To change this template use File | Settings | File Templates.
 */
public class MessageEvent extends ApplicationEvent {

    private String message;

    public MessageEvent(Object source, String message) {
        super(source);
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}

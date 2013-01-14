package com.gmail.schcrabicus.prospring3.tutorials.ch5.lifecycle.eventListeners;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * Created with IntelliJ IDEA.
 * User: schcrabicus
 * Date: 13.01.13
 * Time: 9:11
 * To change this template use File | Settings | File Templates.
 */
@Component
public class MessageEventListener implements ApplicationListener<MessageEvent> {

    @Override
    public void onApplicationEvent(MessageEvent messageEvent) {
        System.out.println("ApplicationEvent : " + messageEvent.getMessage());
    }
}

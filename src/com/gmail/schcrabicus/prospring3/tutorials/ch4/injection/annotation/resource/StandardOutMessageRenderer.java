package com.gmail.schcrabicus.prospring3.tutorials.ch4.injection.annotation.resource;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created with IntelliJ IDEA.
 * User: schcrabicus
 * Date: 02.01.13
 * Time: 8:37
 * To change this template use File | Settings | File Templates.
 */
@Service("messageRenderer")
public class StandardOutMessageRenderer implements MessageRenderer {

    @Resource(name = "messageProvider")
    private MessageProvider messageProvider;

    public void render(){
        if (messageProvider == null){
            throw new RuntimeException(
                    "You must set the property message provider of class : " +
                            StandardOutMessageRenderer.class.getName()
            );
        }
        System.out.println(messageProvider.getMessage());
    }

    public MessageProvider getMessageProvider() {
        return messageProvider;
    }

    public void setMessageProvider(MessageProvider messageProvider) {
        this.messageProvider = messageProvider;
    }
}

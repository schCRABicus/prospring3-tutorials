package com.gmail.schcrabicus.prospring3.tutorials.ch4.simple.injection.xml;

/**
 * Created with IntelliJ IDEA.
 * User: schcrabicus
 * Date: 02.01.13
 * Time: 8:37
 * To change this template use File | Settings | File Templates.
 */
public class StandardOutMessageRenderer implements MessageRenderer {

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

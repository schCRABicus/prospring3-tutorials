package com.gmail.schcrabicus.prospring3.tutorials.ch5.lifecycle.factoryBeans;

import org.springframework.context.support.GenericXmlApplicationContext;

/**
 * Created with IntelliJ IDEA.
 * User: schcrabicus
 * Date: 11.01.13
 * Time: 7:52
 * To change this template use File | Settings | File Templates.
 */
public class MessageDigesterLauncher {

    public static void main(String[] args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("classpath:**/ch5/lifecycle/factoryBeans/spring-app.xml");
        ctx.refresh();
        MessageDigester digester = (MessageDigester) ctx.getBean("digester");
        digester.digest("Hello World!");
    }

}

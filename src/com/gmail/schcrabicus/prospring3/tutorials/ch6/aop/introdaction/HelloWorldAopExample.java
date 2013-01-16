package com.gmail.schcrabicus.prospring3.tutorials.ch6.aop.introdaction;

import org.springframework.aop.framework.ProxyFactory;

/**
 * Created with IntelliJ IDEA.
 * User: schcrabicus
 * Date: 15.01.13
 * Time: 7:52
 * To change this template use File | Settings | File Templates.
 */
public class HelloWorldAopExample {

    public static void main(String[] args) {
        MessageWriter target = new MessageWriter();

        ProxyFactory proxyFactory = new ProxyFactory();
        proxyFactory.setTarget(target);
        proxyFactory.addAdvice(new MessageDecorator());

        MessageWriter messageWriter = (MessageWriter) proxyFactory.getProxy();

        System.out.println("Message without AOP :");
        target.writeMessage();
        System.out.println("");
        System.out.println("---------------------");
        System.out.println("Message with AOP :");
        messageWriter.writeMessage();
    }
}

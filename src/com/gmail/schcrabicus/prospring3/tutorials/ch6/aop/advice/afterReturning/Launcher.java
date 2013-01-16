package com.gmail.schcrabicus.prospring3.tutorials.ch6.aop.advice.afterReturning;

import org.springframework.aop.framework.ProxyFactory;
import org.springframework.context.ApplicationContext;

/**
 * Created with IntelliJ IDEA.
 * User: schcrabicus
 * Date: 16.01.13
 * Time: 7:53
 * To change this template use File | Settings | File Templates.
 */
public class Launcher {

    public static void main(String[] args) {

        MessageWriter target = new MessageWriter();

        ProxyFactory proxyFactory = new ProxyFactory();
        proxyFactory.setTarget(target);
        proxyFactory.addAdvice(new SimpleAfterReturningAdvice());

        MessageWriter writer = (MessageWriter) proxyFactory.getProxy();
        writer.writeMessage();
    }
}

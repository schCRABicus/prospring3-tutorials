package com.gmail.schcrabicus.prospring3.tutorials.ch6.aop.advice.before.java;

import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.aop.framework.ProxyFactory;

import java.lang.reflect.Method;

/**
 * Created with IntelliJ IDEA.
 * User: schcrabicus
 * Date: 15.01.13
 * Time: 8:05
 * To change this template use File | Settings | File Templates.
 */
public class SimpleBeforeAdvice implements MethodBeforeAdvice{

    public static void main(String[] args) {
        MessageWriter target = new MessageWriter();

        ProxyFactory proxyFactory = new ProxyFactory();
        proxyFactory.setTarget(target);
        proxyFactory.addAdvice(new SimpleBeforeAdvice());

        MessageWriter writer = (MessageWriter)proxyFactory.getProxy();
        writer.writeMessage();
    }

    @Override
    public void before(Method method, Object[] objects, Object o) throws Throwable {
        System.out.println("Before " + method.getName());
    }
}

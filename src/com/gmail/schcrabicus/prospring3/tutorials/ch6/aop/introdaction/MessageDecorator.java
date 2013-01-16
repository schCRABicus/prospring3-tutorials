package com.gmail.schcrabicus.prospring3.tutorials.ch6.aop.introdaction;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

/**
 * Created with IntelliJ IDEA.
 * User: schcrabicus
 * Date: 15.01.13
 * Time: 7:50
 * To change this template use File | Settings | File Templates.
 */
public class MessageDecorator implements MethodInterceptor {

    @Override
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        System.out.print("Hello, ");
        Object result = methodInvocation.proceed();
        System.out.println("!");

        return result;
    }
}

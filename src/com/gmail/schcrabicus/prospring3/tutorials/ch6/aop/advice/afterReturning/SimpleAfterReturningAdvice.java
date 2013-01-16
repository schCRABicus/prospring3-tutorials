package com.gmail.schcrabicus.prospring3.tutorials.ch6.aop.advice.afterReturning;

import org.springframework.aop.AfterReturningAdvice;

import java.lang.reflect.Method;

/**
 * Created with IntelliJ IDEA.
 * User: schcrabicus
 * Date: 16.01.13
 * Time: 7:52
 * To change this template use File | Settings | File Templates.
 */
public class SimpleAfterReturningAdvice implements AfterReturningAdvice {

    @Override
    public void afterReturning(Object o, Method method, Object[] objects, Object o2) throws Throwable {
        System.out.println("");
        System.out.println("After returning,method = " + method.getName());
    }
}

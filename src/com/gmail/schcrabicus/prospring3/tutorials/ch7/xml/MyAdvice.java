package com.gmail.schcrabicus.prospring3.tutorials.ch7.xml;

import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

/**
 * Created with IntelliJ IDEA.
 * User: schcrabicus
 * Date: 22.01.13
 * Time: 7:28
 * To change this template use File | Settings | File Templates.
 */
public class MyAdvice implements MethodBeforeAdvice{
    @Override
    public void before(Method method, Object[] objects, Object o) throws Throwable {
        System.out.println(" >> ... Before advice - executing method : " + method.getName());
    }
}

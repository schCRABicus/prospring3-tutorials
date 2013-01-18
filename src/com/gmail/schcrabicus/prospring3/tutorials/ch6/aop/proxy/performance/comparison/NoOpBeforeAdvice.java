package com.gmail.schcrabicus.prospring3.tutorials.ch6.aop.proxy.performance.comparison;

import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

/**
 * Created with IntelliJ IDEA.
 * User: schcrabicus
 * Date: 18.01.13
 * Time: 8:08
 * To change this template use File | Settings | File Templates.
 */
public class NoOpBeforeAdvice implements MethodBeforeAdvice {

    @Override
    public void before(Method method, Object[] objects, Object o) throws Throwable {
        //System.out.println("Works before advice");
    }
}

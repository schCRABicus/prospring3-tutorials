package com.gmail.schcrabicus.prospring3.tutorials.ch7.pointcuts.advanced.controlFlowPointcut;

import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

/**
 * Created with IntelliJ IDEA.
 * User: schcrabicus
 * Date: 18.01.13
 * Time: 8:30
 * To change this template use File | Settings | File Templates.
 */
public class SimpleBeforeAdvice implements MethodBeforeAdvice {
    @Override
    public void before(Method method, Object[] objects, Object o) throws Throwable {
        System.out.println("Before method : " + method);
    }
}

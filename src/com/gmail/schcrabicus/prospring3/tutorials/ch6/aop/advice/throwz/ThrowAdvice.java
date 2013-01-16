package com.gmail.schcrabicus.prospring3.tutorials.ch6.aop.advice.throwz;

import org.springframework.aop.ThrowsAdvice;

import java.lang.reflect.Method;

/**
 * Created with IntelliJ IDEA.
 * User: schcrabicus
 * Date: 16.01.13
 * Time: 8:43
 * To change this template use File | Settings | File Templates.
 */
public class ThrowAdvice implements ThrowsAdvice {

    public void afterThrowing(Exception ex) throws Throwable {
        System.out.println("***");
        System.out.println("Generic Exception Capture");
        System.out.println("Caught: " + ex.getClass().getName());
        System.out.println("***\n");
    }

    public void afterThrowing(Method method, Object[] args, Object target, IllegalArgumentException ex) throws Throwable{
        System.out.println("***");
        System.out.println("IllegalArgumentException Capture");
        System.out.println("Caught: " + ex.getClass().getName());
        System.out.println("Method: " + method.getName());
        System.out.println("***\n");
    }
}

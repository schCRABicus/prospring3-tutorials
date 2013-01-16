package com.gmail.schcrabicus.prospring3.tutorials.ch6.aop.advice.afterReturning;

import org.springframework.aop.AfterReturningAdvice;

import java.lang.reflect.Method;

/**
 * Created with IntelliJ IDEA.
 * User: schcrabicus
 * Date: 16.01.13
 * Time: 8:01
 * To change this template use File | Settings | File Templates.
 */
public class MoreComplexAfterReturningAdvice implements AfterReturningAdvice {

    @Override
    public void afterReturning(Object o, Method method, Object[] objects, Object o2) throws Throwable {
        System.out.println("Works afterReturning after : " + method.getName());

        if ( o2 instanceof TargetObject ){
            if (method.getName() != null && method.getName().equals("doCalculations")){
                System.out.println("doCalculations has just been executed..., it returned " + ((Integer)o).intValue());
            } else if (method.getName() != null && method.getName().equals("getValue")){
                int returnedValue = ((Integer)o).intValue();
                System.out.println("getValue has just been executed..., it returned " + returnedValue);

                if (returnedValue == 2){
                    System.out.println("returnedValue == 2, rejecting...");
                    throw new SecurityException("Rejecting... method returned 2");
                }
            }
        }
    }
}

package com.gmail.schcrabicus.prospring3.tutorials.ch6.aop.advisors.statics;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

/**
 * Created with IntelliJ IDEA.
 * User: schcrabicus
 * Date: 17.01.13
 * Time: 7:35
 * To change this template use File | Settings | File Templates.
 */
public class AroundAdvice implements MethodInterceptor {

    @Override
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        System.out.println(">> Invoking " + methodInvocation.getMethod().getName());
        Object retVal = methodInvocation.proceed();
        System.out.println(">> Done");
        return retVal;
    }
}

package com.gmail.schcrabicus.prospring3.tutorials.ch6.aop.advisors.dynamic.convenience;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.util.StopWatch;

import java.lang.reflect.Method;

/**
 * Created with IntelliJ IDEA.
 * User: schcrabicus
 * Date: 18.01.13
 * Time: 7:52
 * To change this template use File | Settings | File Templates.
 */
public class AroundAdvice implements MethodInterceptor {

    @Override
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        System.out.println(" >> Invoking method " + methodInvocation.getMethod().getName());
        StopWatch stopWatch = new StopWatch(methodInvocation.getMethod().getName());
        stopWatch.start();
        Object retVal = methodInvocation.proceed();
        stopWatch.stop();
        dumpInfo(methodInvocation, stopWatch.getTotalTimeMillis());
        System.out.println(" >> Done");

        return retVal;
    }

    private void dumpInfo(MethodInvocation invocation, long time){
        Method method = invocation.getMethod();
        Object target = invocation.getThis();
        Object[] args = invocation.getArguments();

        System.out.println("... >> Method : " + method.getName());
        System.out.println("... >> of class : " + target.getClass().getName());
        System.out.println("... >> with arguments : ");

        for (Object arg : args){
            System.out.println(".......  : " + arg.toString());
        }

        System.out.println(" >> Invokation took " + time + " ms");
    }
}

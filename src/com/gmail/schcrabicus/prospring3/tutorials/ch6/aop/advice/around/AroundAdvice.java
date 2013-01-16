package com.gmail.schcrabicus.prospring3.tutorials.ch6.aop.advice.around;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.util.StopWatch;

import java.lang.reflect.Method;

/**
 * Created with IntelliJ IDEA.
 * User: schcrabicus
 * Date: 16.01.13
 * Time: 8:26
 * To change this template use File | Settings | File Templates.
 */
public class AroundAdvice implements MethodInterceptor {

    @Override
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        StopWatch sw = new StopWatch();

        sw.start(methodInvocation.getMethod().getName());
        Object returnValue = methodInvocation.proceed();
        sw.stop();
        dumpInfo(methodInvocation, sw.getTotalTimeMillis());
        return returnValue;
    }

    private void dumpInfo(MethodInvocation invocation, long ms) {
        Method m = invocation.getMethod();
        Object target = invocation.getThis();
        Object[] args = invocation.getArguments();
        System.out.println("Executed method: " + m.getName());
        System.out.println("On object of type: " +
                target.getClass().getName());
        System.out.println("With arguments:");
        for (int x = 0; x < args.length; x++) {
            System.out.print(" > " + args[x]);
        }
        System.out.print("\n");
        System.out.println("Took: " + ms + " ms");
    }
}

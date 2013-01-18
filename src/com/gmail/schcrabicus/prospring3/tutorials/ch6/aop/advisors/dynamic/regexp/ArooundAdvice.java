package com.gmail.schcrabicus.prospring3.tutorials.ch6.aop.advisors.dynamic.regexp;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.util.StopWatch;

import java.lang.reflect.Method;

/**
 * Created with IntelliJ IDEA.
 * User: schcrabicus
 * Date: 17.01.13
 * Time: 8:27
 * To change this template use File | Settings | File Templates.
 */
public class ArooundAdvice implements MethodInterceptor {

    @Override
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        System.out.println(">> Starting AroundAdvice");
        StopWatch stopWatch = new StopWatch(methodInvocation.getMethod().getName());
        stopWatch.start();
        Object retval = methodInvocation.proceed();
        stopWatch.stop();

        dumpInfo(methodInvocation, stopWatch.getTotalTimeMillis());
        return retval;
    }

    private void dumpInfo(MethodInvocation methodInvocation, long time){
        Method method = methodInvocation.getMethod();
        Object target = methodInvocation.getThis();
        Object[] args = methodInvocation.getArguments();
        System.out.println(" >> invoking method " + method.getName());
        System.out.println(" >> .. of class " + target.getClass().getName());
        System.out.println(" >> .. with arguments :  ");
        for (Object arg : args){
            System.out.println("...... " + arg);
        }
        System.out.println("Invokation took " + time + "ms");
    }
}

package com.gmail.schcrabicus.prospring3.tutorials.ch7.namespace.aop.extra;

import org.aspectj.lang.JoinPoint;

/**
 * Created with IntelliJ IDEA.
 * User: schcrabicus
 * Date: 22.01.13
 * Time: 8:33
 * To change this template use File | Settings | File Templates.
 */
public class MyAdvice {

    public void simpleBeforeAdvice(JoinPoint joinPoint){
        System.out.println(" >> Executing " + joinPoint.getSignature().getDeclaringTypeName() + " " + joinPoint.getSignature().getName());
        System.out.println("... args : ");
        Object[] args = joinPoint.getArgs();
        for (Object arg : args){
            System.out.println("... " + arg);
        }
        if (args.length > 0 && ((Integer)args[0]).intValue() != 100){
            System.out.println(" argument is not 100" );
        }
        System.out.println("------------------------" );


    }
}

package com.gmail.schcrabicus.prospring3.tutorials.ch7.namespace.aop;

import org.aspectj.lang.JoinPoint;

/**
 * Created with IntelliJ IDEA.
 * User: schcrabicus
 * Date: 22.01.13
 * Time: 8:17
 * To change this template use File | Settings | File Templates.
 */
public class Myadvice {

    public void simpleBeforeAdvice(JoinPoint joinPoint){
        System.out.println(" >> Executing : " + joinPoint.getSignature().getDeclaringTypeName() + " " + joinPoint.getSignature().getName());
    }
}

package com.gmail.schcrabicus.prospring3.tutorials.ch7.namespace.aop.composite;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

/**
 * Created with IntelliJ IDEA.
 * User: schcrabicus
 * Date: 23.01.13
 * Time: 7:22
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

    public Object simpleAroundAdvice(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println(" >> around advice... Before execution: " +
                joinPoint.getSignature().getDeclaringTypeName() + " "
                + joinPoint.getSignature().getName()
                + " argument: " + null);
        Object retVal = joinPoint.proceed();
        System.out.println(" >> around advice... After execution: " +
                joinPoint.getSignature().getDeclaringTypeName() + " "
                + joinPoint.getSignature().getName() + " argument: " + null);
        return retVal;
    }
}

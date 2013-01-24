package com.gmail.schcrabicus.prospring3.tutorials.ch7.namespace.aop.aspectj;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * Created with IntelliJ IDEA.
 * User: schcrabicus
 * Date: 23.01.13
 * Time: 7:48
 * To change this template use File | Settings | File Templates.
 */
@Component
@Aspect
public class MyAdvice {

    @Pointcut("execution(* foo*(int)) && args(intValue)")
    public void fooExecution(int intValue){

    }

    @Pointcut("bean(myDependency)")
    public void inMyDependency(){}

    @Before("fooExecution(intValue) && inMyDependency()")
    public void simpleBeforeAdvice(JoinPoint joinPoint, int intValue){
        System.out.println(" >> Executing " + joinPoint.getSignature().getDeclaringTypeName() + " " + joinPoint.getSignature().getName());
        System.out.println("... args : ");
        Object[] args = joinPoint.getArgs();
        for (Object arg : args){
            System.out.println("... " + arg);
        }
        if (args.length > 0 && ((Integer)args[0]).intValue() != 100){
            System.out.println(" argument is not 100" );
        }
        System.out.println("... intValue = " + intValue);
        System.out.println("------------------------" );
    }

    @Around("fooExecution(intValue) && inMyDependency()")
    public Object simpleAroundAdvice(ProceedingJoinPoint joinPoint, int intValue) throws Throwable {
        System.out.println(" >> around advice... Before execution: " +
                joinPoint.getSignature().getDeclaringTypeName() + " "
                + joinPoint.getSignature().getName()
                + " argument: " + intValue);
        Object retVal = joinPoint.proceed();
        System.out.println(" >> around advice... After execution: " +
                joinPoint.getSignature().getDeclaringTypeName() + " "
                + joinPoint.getSignature().getName() + " argument: " + intValue);
        return retVal;
    }
}

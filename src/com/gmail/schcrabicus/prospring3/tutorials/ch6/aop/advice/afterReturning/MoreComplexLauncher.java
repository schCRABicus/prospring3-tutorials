package com.gmail.schcrabicus.prospring3.tutorials.ch6.aop.advice.afterReturning;

import org.springframework.aop.framework.ProxyFactory;

/**
 * Created with IntelliJ IDEA.
 * User: schcrabicus
 * Date: 16.01.13
 * Time: 8:09
 * To change this template use File | Settings | File Templates.
 */
public class MoreComplexLauncher {

    public static void main(String[] args) {
        TargetObject target = new TargetObject();

        ProxyFactory proxyFactory = new ProxyFactory();
        proxyFactory.setTarget(target);
        proxyFactory.addAdvice(new MoreComplexAfterReturningAdvice());

        TargetObject object = (TargetObject) proxyFactory.getProxy();
        int res1 = 0;
        int[] res2 = new int[10];
        try{
            res1 = object.doCalculations();
            for (int i = 0; i< 10; i++){
                res2[i] = object.getValue();
            }

        } catch(SecurityException ex){
            System.out.println("Caught SecurityException : " + ex.getMessage());
        }

        System.out.println("res1 = " + res1);
        for (int i = 0; i< 10; i++){
            System.out.println("res2[" + i + "] = " + res2[i]);
        }
    }
}

package com.gmail.schcrabicus.prospring3.tutorials.ch6.aop.advice.before.secure;

import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

/**
 * Created with IntelliJ IDEA.
 * User: schcrabicus
 * Date: 15.01.13
 * Time: 8:25
 * To change this template use File | Settings | File Templates.
 */
public class SecurityAdvice implements MethodBeforeAdvice{

    private SecurityManager securityManager;

    public SecurityAdvice(){
        this.securityManager = new SecurityManager();
    }

    @Override
    public void before(Method method, Object[] objects, Object o) throws Throwable {
        UserInfo userInfo = securityManager.getLoggedUser();

        System.out.println("Before , userInfo : " + userInfo);

        if ( userInfo == null ){
            throw new SecurityException("You must login before attempting to invoke the method: " + method.getName());
        } else if ("Kolya".equals(userInfo.getFirstName())) {
            System.out.println("Logged in user is Kolya - OKAY!");
        } else {
            System.out.println("Logged in user is " + userInfo.getFirstName() + " NOT GOOD :(");
            throw new SecurityException("User " + userInfo.getFirstName()
                    + " is not allowed access to method " + method.getName());
        }
    }
}

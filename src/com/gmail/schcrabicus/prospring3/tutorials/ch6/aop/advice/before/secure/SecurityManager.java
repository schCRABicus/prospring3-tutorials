package com.gmail.schcrabicus.prospring3.tutorials.ch6.aop.advice.before.secure;

/**
 * Created with IntelliJ IDEA.
 * User: schcrabicus
 * Date: 15.01.13
 * Time: 8:24
 * To change this template use File | Settings | File Templates.
 */
public class SecurityManager {

    private static ThreadLocal<UserInfo> threadLocal = new ThreadLocal<UserInfo>();

    public void login(UserInfo userInfo){
        threadLocal.set(userInfo);
    }

    public void logout(){
        threadLocal.set(null);
    }

    public UserInfo getLoggedUser(){
        return threadLocal.get();
    }
}

package com.gmail.schcrabicus.prospring3.tutorials.ch6.aop.advice.before.secure;

/**
 * Created with IntelliJ IDEA.
 * User: schcrabicus
 * Date: 15.01.13
 * Time: 8:17
 * To change this template use File | Settings | File Templates.
 */
public class SecureBean {

    public void writeSecuredMessage(){
        System.out.println("This message is allowed only for Kolya");
    }
}

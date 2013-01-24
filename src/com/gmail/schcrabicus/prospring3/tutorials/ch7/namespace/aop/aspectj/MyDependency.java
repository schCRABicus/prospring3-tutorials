package com.gmail.schcrabicus.prospring3.tutorials.ch7.namespace.aop.aspectj;

import org.springframework.stereotype.Component;

/**
 * Created with IntelliJ IDEA.
 * User: schcrabicus
 * Date: 23.01.13
 * Time: 7:45
 * To change this template use File | Settings | File Templates.
 */
@Component
public class MyDependency {

    public void foo(int intValue) {
        System.out.println("foo(int): " + intValue);
    }
    public void bar() {
        System.out.println("bar()");
    }
}

package com.gmail.schcrabicus.prospring3.tutorials.ch7.namespace.aop.aspectj;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created with IntelliJ IDEA.
 * User: schcrabicus
 * Date: 23.01.13
 * Time: 7:46
 * To change this template use File | Settings | File Templates.
 */
@Component
public class MyBean {

    @Autowired
    private MyDependency myDependency;

    public void execute() {
        myDependency.foo(100);
        myDependency.foo(101);
        myDependency.bar();
    }
}

package com.gmail.schcrabicus.prospring3.tutorials.ch7.namespace.aop.composite;

/**
 * Created with IntelliJ IDEA.
 * User: schcrabicus
 * Date: 22.01.13
 * Time: 8:15
 * To change this template use File | Settings | File Templates.
 */
public class MyDependency {

    public void foo(int x){
        System.out.println("foo(int): " + x);
    }

    public void bar(){
        System.out.println("bar");
    }
}

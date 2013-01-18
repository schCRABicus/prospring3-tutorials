package com.gmail.schcrabicus.prospring3.tutorials.ch6.aop.advisors.dynamic.simple;

/**
 * Created with IntelliJ IDEA.
 * User: schcrabicus
 * Date: 17.01.13
 * Time: 7:52
 * To change this template use File | Settings | File Templates.
 */
public class SampleBean {

    public void foo(int x){
        System.out.println("Invoked foo with x = " + x);
    }

    public void bar(){
        System.out.println("Invoked bar");
    }
}

package com.gmail.schcrabicus.prospring3.tutorials.ch6.aop.advisors.dynamic.aspectj;

/**
 * Created with IntelliJ IDEA.
 * User: schcrabicus
 * Date: 17.01.13
 * Time: 8:42
 * To change this template use File | Settings | File Templates.
 */
public class AspectjBean {

    public void foo1(){
        System.out.println("foo1 works...");
    }

    public void foo2(){
        System.out.println("foo2 works...");
    }

    public void foo2(int x){
        System.out.println("foo2 with arg = " + x + " works...");
    }

    public void bar(){
        System.out.println("bar works...");
    }

}

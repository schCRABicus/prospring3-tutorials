package com.gmail.schcrabicus.prospring3.tutorials.ch6.aop.advisors.dynamic.nameMatching;

/**
 * Created with IntelliJ IDEA.
 * User: schcrabicus
 * Date: 17.01.13
 * Time: 8:10
 * To change this template use File | Settings | File Templates.
 */
public class NameBean {

    public void foo() {
        System.out.println("foo");
    }
    public void foo(int x) {
        System.out.println("foo " + x);
    }
    public void bar() {
        System.out.println("bar");
    }
    public void yup() {
        System.out.println("yup");
    }

}

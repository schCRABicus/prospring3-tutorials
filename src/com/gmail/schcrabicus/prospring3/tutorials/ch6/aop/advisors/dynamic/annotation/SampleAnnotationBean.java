package com.gmail.schcrabicus.prospring3.tutorials.ch6.aop.advisors.dynamic.annotation;

/**
 * Created with IntelliJ IDEA.
 * User: schcrabicus
 * Date: 18.01.13
 * Time: 7:42
 * To change this template use File | Settings | File Templates.
 */
public class SampleAnnotationBean {

    @AdviceRequired
    public void foo(int x) {
        System.out.println("Invoked foo() with: " + x);
    }

    public void bar() {
        System.out.println("Invoked bar()");
    }
}

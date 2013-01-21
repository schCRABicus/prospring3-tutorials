package com.gmail.schcrabicus.prospring3.tutorials.ch7.introductions.my;

import org.springframework.aop.support.DelegatingIntroductionInterceptor;

/**
 * Created with IntelliJ IDEA.
 * User: schcrabicus
 * Date: 21.01.13
 * Time: 8:34
 * To change this template use File | Settings | File Templates.
 */
public class MyIntroduction extends DelegatingIntroductionInterceptor implements MyDecoration {
    @Override
    public void callAddedMethod() {
        System.out.println("Called mixed method...");
    }
}

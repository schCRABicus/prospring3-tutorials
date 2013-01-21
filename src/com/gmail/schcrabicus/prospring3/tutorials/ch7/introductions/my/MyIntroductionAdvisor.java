package com.gmail.schcrabicus.prospring3.tutorials.ch7.introductions.my;

import org.aopalliance.aop.Advice;
import org.springframework.aop.support.DefaultIntroductionAdvisor;

/**
 * Created with IntelliJ IDEA.
 * User: schcrabicus
 * Date: 21.01.13
 * Time: 8:37
 * To change this template use File | Settings | File Templates.
 */
public class MyIntroductionAdvisor extends DefaultIntroductionAdvisor {

    public MyIntroductionAdvisor() {
        super(new MyIntroduction());
    }
}

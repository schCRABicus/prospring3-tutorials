package com.gmail.schcrabicus.prospring3.tutorials.ch7.introductions.my;

import org.springframework.aop.DynamicIntroductionAdvice;
import org.springframework.aop.IntroductionAdvisor;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.DefaultIntroductionAdvisor;

/**
 * Created with IntelliJ IDEA.
 * User: schcrabicus
 * Date: 21.01.13
 * Time: 8:39
 * To change this template use File | Settings | File Templates.
 */
public class MyIntroductionExample {

    public static void main(String[] args) {
        TargetBean target = new TargetBean();

        IntroductionAdvisor advisor = new MyIntroductionAdvisor();

        ProxyFactory proxyFactory = new ProxyFactory();
        proxyFactory.setTarget(target);
        proxyFactory.addAdvisor(advisor);

        proxyFactory.setOptimize(true);

        TargetBean bean = (TargetBean) proxyFactory.getProxy();
        MyDecoration decoration = (MyDecoration) bean;

        bean.foo();
        ((MyDecoration) bean).callAddedMethod();
    }
}

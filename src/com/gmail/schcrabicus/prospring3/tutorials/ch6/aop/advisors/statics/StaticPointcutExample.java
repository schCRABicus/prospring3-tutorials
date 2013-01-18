package com.gmail.schcrabicus.prospring3.tutorials.ch6.aop.advisors.statics;

import org.aopalliance.aop.Advice;
import org.springframework.aop.Advisor;
import org.springframework.aop.Pointcut;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.DefaultPointcutAdvisor;

/**
 * Created with IntelliJ IDEA.
 * User: schcrabicus
 * Date: 17.01.13
 * Time: 7:35
 * To change this template use File | Settings | File Templates.
 */
public class StaticPointcutExample {

    public static void main(String[] args) {
        BeanOne one = new BeanOne();
        BeanTwo two = new BeanTwo();

        BeanOne proxyOne;
        BeanTwo proxyTwo;

        // create pointcut, advice and advisor
        Pointcut pointcut = new SimpleStaticPointcut();
        Advice advice = new AroundAdvice();
        Advisor advisor = new DefaultPointcutAdvisor(pointcut, advice);

        // create beanOne proxy
        ProxyFactory proxyFactory = new ProxyFactory();
        proxyFactory.setTarget(one);
        proxyFactory.addAdvisor(advisor);
        proxyOne = (BeanOne)proxyFactory.getProxy();

        proxyFactory = new ProxyFactory();
        proxyFactory.addAdvisor(advisor);
        proxyFactory.setTarget(two);
        proxyTwo = (BeanTwo) proxyFactory.getProxy();

        proxyOne.foo();
        proxyTwo.foo();

        proxyOne.bar();
        proxyTwo.bar();
    }
}

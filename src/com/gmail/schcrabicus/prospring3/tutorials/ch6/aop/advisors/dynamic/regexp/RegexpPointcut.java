package com.gmail.schcrabicus.prospring3.tutorials.ch6.aop.advisors.dynamic.regexp;

import org.aopalliance.aop.Advice;
import org.springframework.aop.Advisor;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.aop.support.JdkRegexpMethodPointcut;

/**
 * Created with IntelliJ IDEA.
 * User: schcrabicus
 * Date: 17.01.13
 * Time: 8:35
 * To change this template use File | Settings | File Templates.
 */
public class RegexpPointcut {

    public static void main(String[] args) {
        SampleBean target = new SampleBean();

        JdkRegexpMethodPointcut pointcut = new JdkRegexpMethodPointcut();
        pointcut.setPattern(".*foo.*");
        Advice advice = new ArooundAdvice();
        Advisor advisor = new DefaultPointcutAdvisor(pointcut, advice);

        ProxyFactory proxyFactory = new ProxyFactory();
        proxyFactory.setTarget(target);
        proxyFactory.addAdvisor(advisor);

        SampleBean bean = (SampleBean) proxyFactory.getProxy();

        bean.foo1();
        bean.bar();
        bean.foo2();
        bean.foo2(20);

    }
}

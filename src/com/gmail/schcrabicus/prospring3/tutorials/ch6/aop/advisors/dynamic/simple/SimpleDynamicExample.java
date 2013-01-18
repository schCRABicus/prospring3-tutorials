package com.gmail.schcrabicus.prospring3.tutorials.ch6.aop.advisors.dynamic.simple;

import com.gmail.schcrabicus.prospring3.tutorials.ch6.aop.advisors.statics.AroundAdvice;
import org.aopalliance.aop.Advice;
import org.springframework.aop.Advisor;
import org.springframework.aop.Pointcut;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.DefaultPointcutAdvisor;

/**
 * Created with IntelliJ IDEA.
 * User: schcrabicus
 * Date: 17.01.13
 * Time: 7:53
 * To change this template use File | Settings | File Templates.
 */
public class SimpleDynamicExample {

    public static void main(String[] args) {
        SampleBean target = new SampleBean();

        Pointcut pointcut = new SimpleDynamicPointcut();
        Advice advice = new com.gmail.schcrabicus.prospring3.tutorials.ch6.aop.advice.around.AroundAdvice();
        Advisor advisor = new DefaultPointcutAdvisor(pointcut, advice);

        ProxyFactory proxyFactory = new ProxyFactory();
        proxyFactory.setTarget(target);
        proxyFactory.addAdvisor(advisor);
        SampleBean bean = (SampleBean) proxyFactory.getProxy();

        bean.bar();
        bean.foo(1);
        bean.foo(100);
        bean.foo(50);

        bean.bar();
        bean.bar();
        bean.bar();
    }
}

package com.gmail.schcrabicus.prospring3.tutorials.ch6.aop.advisors.dynamic.nameMatching;

import com.gmail.schcrabicus.prospring3.tutorials.ch6.aop.advice.around.AroundAdvice;
import org.springframework.aop.Advisor;
import org.springframework.aop.Pointcut;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.aop.support.NameMatchMethodPointcut;

/**
 * Created with IntelliJ IDEA.
 * User: schcrabicus
 * Date: 17.01.13
 * Time: 8:16
 * To change this template use File | Settings | File Templates.
 */
public class NamePointcutExample {

    public static void main(String[] args) {
        NameBean target = new NameBean();

        NameMatchMethodPointcut pointcut = new NameMatchMethodPointcut();
        pointcut.addMethodName("foo");
        pointcut.addMethodName("bar");
        Advisor advisor = new DefaultPointcutAdvisor(pointcut, new AroundAdvice());

        ProxyFactory proxyFactory = new ProxyFactory();
        proxyFactory.addAdvisor(advisor);
        proxyFactory.setTarget(target);

        NameBean bean = (NameBean) proxyFactory.getProxy();

        bean.bar();
        bean.foo();
        bean.foo(100);
        bean.yup();
    }
}

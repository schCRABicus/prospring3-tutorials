package com.gmail.schcrabicus.prospring3.tutorials.ch6.aop.advisors.dynamic.annotation;

import com.gmail.schcrabicus.prospring3.tutorials.ch6.aop.advisors.dynamic.regexp.ArooundAdvice;
import org.springframework.aop.Advisor;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.aop.support.annotation.AnnotationMatchingPointcut;

/**
 * Created with IntelliJ IDEA.
 * User: schcrabicus
 * Date: 18.01.13
 * Time: 7:43
 * To change this template use File | Settings | File Templates.
 */
public class AnnotationPointcutExample {

    public static void main(String[] args) {
        SampleAnnotationBean target = new SampleAnnotationBean();

        AnnotationMatchingPointcut pointcut = AnnotationMatchingPointcut.forMethodAnnotation(AdviceRequired.class);
        Advisor advisor = new DefaultPointcutAdvisor(pointcut, new ArooundAdvice());

        ProxyFactory proxyFactory = new ProxyFactory();
        proxyFactory.setTarget(target);
        proxyFactory.addAdvisor(advisor);
        SampleAnnotationBean bean = (SampleAnnotationBean) proxyFactory.getProxy();

        bean.bar();
        bean.foo(200);
    }
}

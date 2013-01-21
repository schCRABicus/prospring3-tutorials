package com.gmail.schcrabicus.prospring3.tutorials.ch7.pointcuts.advanced.controlFlowPointcut;

import org.springframework.aop.Advisor;
import org.springframework.aop.Pointcut;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.ControlFlowPointcut;
import org.springframework.aop.support.DefaultPointcutAdvisor;

/**
 * Created with IntelliJ IDEA.
 * User: schcrabicus
 * Date: 21.01.13
 * Time: 7:21
 * To change this template use File | Settings | File Templates.
 */
public class ControlFlowExample {

    public static void main(String[] args) {
        ControlFlowExample example = new ControlFlowExample();
        example.run();
    }

    public void run(){
        TestBean target = new TestBean();

        Pointcut pointcut = new ControlFlowPointcut(ControlFlowExample.class, "test");
        Advisor advisor = new DefaultPointcutAdvisor(pointcut, new SimpleBeforeAdvice());

        ProxyFactory proxyFactory = new ProxyFactory();
        proxyFactory.setTarget(target);
        proxyFactory.addAdvisor(advisor);

        TestBean proxy = (TestBean) proxyFactory.getProxy();
        System.out.println("Trying normal invoke");
        proxy.foo();
        System.out.println("Trying under ControlFlowExample.test()");
        test(proxy);

    }

    public void test(TestBean bean){
        bean.foo();
    }
}

package com.gmail.schcrabicus.prospring3.tutorials.ch6.aop.advice.around;

import org.springframework.aop.framework.ProxyFactory;

/**
 * Created with IntelliJ IDEA.
 * User: schcrabicus
 * Date: 16.01.13
 * Time: 8:29
 * To change this template use File | Settings | File Templates.
 */
public class AroundLauncher {

    public static void main(String[] args) {
        getWorkerBean().doSomeWork(100000);
    }

    private static WorkerBean getWorkerBean(){
        WorkerBean target = new WorkerBean();

        ProxyFactory proxyFactory = new ProxyFactory();
        proxyFactory.setTarget(target);
        proxyFactory.addAdvice(new AroundAdvice());

        return (WorkerBean) proxyFactory.getProxy();
    }
}

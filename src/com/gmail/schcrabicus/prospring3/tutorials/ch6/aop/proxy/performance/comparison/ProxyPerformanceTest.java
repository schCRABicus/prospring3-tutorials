package com.gmail.schcrabicus.prospring3.tutorials.ch6.aop.proxy.performance.comparison;

import org.springframework.aop.Advisor;
import org.springframework.aop.framework.Advised;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.DefaultPointcutAdvisor;

/**
 * Created with IntelliJ IDEA.
 * User: schcrabicus
 * Date: 18.01.13
 * Time: 8:09
 * To change this template use File | Settings | File Templates.
 */
public class ProxyPerformanceTest {

    public static void main(String[] args) {
        ISimpleBean target = new SimpleBean();

        Advisor advisor = new DefaultPointcutAdvisor(new TestStaticPointcut(), new NoOpBeforeAdvice());

        runCglibTests(advisor, target);
        runCglibFroxenTests(advisor, target);
        runJdkTests(advisor, target);
    }

    private static void runCglibTests(Advisor advisor, ISimpleBean target){
        ProxyFactory proxyFactory = new ProxyFactory();
        proxyFactory.setTarget(target);
        proxyFactory.addAdvisor(advisor);

        ISimpleBean bean = (SimpleBean) proxyFactory.getProxy();
        System.out.println(" >> Running CGLIB (Standard) Tests");
        test(bean);
        System.out.println(" >> CGLIB (Standard) Tests DONE !");
        System.out.println("---------------------------------");
        System.out.println("");
    }

    private static void runCglibFroxenTests(Advisor advisor, ISimpleBean target){
        ProxyFactory proxyFactory = new ProxyFactory();
        proxyFactory.setProxyTargetClass(true);
        proxyFactory.setTarget(target);
        proxyFactory.addAdvisor(advisor);
        proxyFactory.setFrozen(true);

        ISimpleBean bean = (SimpleBean) proxyFactory.getProxy();
        System.out.println(" >> Running CGLIB (Frozen) Tests");
        test(bean);
        System.out.println(" >> CGLIB (Frozen) Tests DONE !");
        System.out.println("---------------------------------");
        System.out.println("");
    }

    private static void runJdkTests(Advisor advisor, ISimpleBean target) {
        ProxyFactory pf = new ProxyFactory();
        pf.setTarget(target);
        pf.addAdvisor(advisor);
        pf.setInterfaces(new Class[]{ISimpleBean.class});

        ISimpleBean proxy = (ISimpleBean)pf.getProxy();
        System.out.println(" >> Running JDK Tests");
        test(proxy);
        System.out.println(" >> JDK Tests DONE !");
        System.out.println("---------------------------------");
        System.out.println("");
    }

    private static void test(ISimpleBean bean) {
        long before;
        long after;

        // Test 1: test advised method
        System.out.println("Testing Advised Method");
        before = System.currentTimeMillis();
        for(int x = 0; x < 50000; x++) {
            bean.advised();
        }
        after = System.currentTimeMillis();
        System.out.println("Took " + (after - before) + " ms");

        // Test 2: testing unadvised method
        System.out.println("Testing Unadvised Method");
        before = System.currentTimeMillis();
        for(int x = 0; x < 50000; x++) {
            bean.unadvised();
        }
        after = System.currentTimeMillis();
        System.out.println("Took " + (after - before) + " ms");

        // Test 3: testing equals() method
        System.out.println("Testing equals() Method");
        before = System.currentTimeMillis();
        for(int x = 0; x < 50000; x++) {
            bean.equals(bean);
        }
        after = System.currentTimeMillis();
        System.out.println("Took " + (after - before) + " ms");

        // Test 4: testing hashCode() method
        System.out.println("Testing hashCode() Method");
        before = System.currentTimeMillis();
        for(int x = 0; x < 50000; x++) {
            bean.hashCode();
        }
        after = System.currentTimeMillis();
        System.out.println("Took " + (after - before) + " ms");

        // Test 5: testing method on Advised
        Advised advised = (Advised)bean;
        System.out.println("Testing Advised.getProxyTargetClass() Method");
        before = System.currentTimeMillis();
        for(int x = 0; x < 50000; x++) {
            advised.getTargetClass();
        }
        after = System.currentTimeMillis();
        System.out.println("Took " + (after - before) + " ms");
        System.out.println(">>>\n");
    }
}

package com.gmail.schcrabicus.prospring3.tutorials.ch7.pointcuts.advanced.composablePointcut;

import com.gmail.schcrabicus.prospring3.tutorials.ch7.pointcuts.advanced.controlFlowPointcut.SimpleBeforeAdvice;
import org.springframework.aop.ClassFilter;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.ComposablePointcut;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.aop.support.StaticMethodMatcher;

import java.lang.reflect.Method;

/**
 * Created with IntelliJ IDEA.
 * User: schcrabicus
 * Date: 21.01.13
 * Time: 7:35
 * To change this template use File | Settings | File Templates.
 */
public class ComposablePointcutExample {

    public static void main(String[] args) {
        SampleBean target = new SampleBean();

        ComposablePointcut pointcut = new ComposablePointcut(ClassFilter.TRUE, new GetterMethodMatcher());

        System.out.println("Test 1");
        SampleBean proxy = getProxy(pointcut, target);
        testInvoke(proxy);

        System.out.println("Test 2 : union getter and setter");
        pointcut.union(new SetterMethodMatcher());
        proxy = getProxy(pointcut, target);
        testInvoke(proxy);

        System.out.println("Test 2 : union getter and setter");
        pointcut.intersection(new GetAgeMethodMatcher());
        proxy = getProxy(pointcut, target);
        testInvoke(proxy);
    }

    private static SampleBean getProxy(ComposablePointcut pointcut, SampleBean target){
        ProxyFactory proxyFactory = new ProxyFactory();
        proxyFactory.setTarget(target);
        proxyFactory.addAdvisor(new DefaultPointcutAdvisor(pointcut, new SimpleBeforeAdvice()));

        return (SampleBean) proxyFactory.getProxy();
    }

    private static void testInvoke(SampleBean proxy){
        proxy.getAge();
        proxy.getName();
        proxy.setName("Vova");
    }

    private static class GetterMethodMatcher extends StaticMethodMatcher {

        @Override
        public boolean matches(Method method, Class<?> aClass) {
            return method.getName().startsWith("get");
        }
    }

    private static class SetterMethodMatcher extends StaticMethodMatcher {

        @Override
        public boolean matches(Method method, Class<?> aClass) {
            return method.getName().startsWith("set");
        }
    }

    private static class GetAgeMethodMatcher extends StaticMethodMatcher {

        @Override
        public boolean matches(Method method, Class<?> aClass) {
            return "getAge".equals(method.getName());
        }
    }
}

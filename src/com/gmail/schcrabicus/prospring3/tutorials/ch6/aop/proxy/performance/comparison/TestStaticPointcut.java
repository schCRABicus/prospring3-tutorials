package com.gmail.schcrabicus.prospring3.tutorials.ch6.aop.proxy.performance.comparison;

import org.springframework.aop.support.StaticMethodMatcherPointcut;

import java.lang.reflect.Method;

/**
 * Created with IntelliJ IDEA.
 * User: schcrabicus
 * Date: 18.01.13
 * Time: 8:05
 * To change this template use File | Settings | File Templates.
 */
public class TestStaticPointcut extends StaticMethodMatcherPointcut {

    @Override
    public boolean matches(Method method, Class<?> aClass) {
        return ("advised".equals(method.getName()));
    }
}

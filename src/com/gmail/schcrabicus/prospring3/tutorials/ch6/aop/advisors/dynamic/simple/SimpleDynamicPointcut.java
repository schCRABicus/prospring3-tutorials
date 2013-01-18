package com.gmail.schcrabicus.prospring3.tutorials.ch6.aop.advisors.dynamic.simple;

import org.springframework.aop.ClassFilter;
import org.springframework.aop.support.DynamicMethodMatcherPointcut;

import java.lang.reflect.Method;

/**
 * Created with IntelliJ IDEA.
 * User: schcrabicus
 * Date: 17.01.13
 * Time: 7:47
 * To change this template use File | Settings | File Templates.
 */
public class SimpleDynamicPointcut extends DynamicMethodMatcherPointcut {

    @Override
    public boolean matches(Method method, Class<?> aClass, Object[] objects) {
        System.out.println("Dynamic matching with args for method " + method.getName());

        int x = ((Integer) objects[0]).intValue();

        return (x != 100);
    }

    @Override
    public boolean matches(Method method, Class<?> targetClass) {
        System.out.println("Simple(static) matching for method " + method.getName());
        return "foo".equals(method.getName());
    }

    @Override
    public ClassFilter getClassFilter() {
        return new ClassFilter() {

            @Override
            public boolean matches(Class<?> aClass) {
                return aClass.equals(SampleBean.class);
            }
        };
    }
}

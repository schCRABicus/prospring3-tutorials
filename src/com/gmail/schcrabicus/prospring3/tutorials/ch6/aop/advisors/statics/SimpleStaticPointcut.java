package com.gmail.schcrabicus.prospring3.tutorials.ch6.aop.advisors.statics;

import org.springframework.aop.ClassFilter;
import org.springframework.aop.support.StaticMethodMatcherPointcut;

import java.lang.reflect.Method;

/**
 * Created with IntelliJ IDEA.
 * User: schcrabicus
 * Date: 17.01.13
 * Time: 7:25
 * To change this template use File | Settings | File Templates.
 */
public class SimpleStaticPointcut extends StaticMethodMatcherPointcut {

    @Override
    public boolean matches(Method method, Class<?> aClass) {
        System.out.println("Matching for method " + method.getName() + " of class " + aClass.getName());
        return "foo".equals(method.getName());
    }

    @Override
    public ClassFilter getClassFilter() {
        return new ClassFilter() {

            @Override
            public boolean matches(Class<?> aClass) {
                return (aClass == BeanOne.class);
            }
        };
    }
}

package com.gmail.schcrabicus.prospring3.tutorials.ch7.namespace.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created with IntelliJ IDEA.
 * User: schcrabicus
 * Date: 22.01.13
 * Time: 8:24
 * To change this template use File | Settings | File Templates.
 */
public class NamespaceExample {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:**/ch7/namespace/aop/spring-config.xml");

        MyBean bean = context.getBean("myBean", MyBean.class);
        bean.execute();
    }
}

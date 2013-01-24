package com.gmail.schcrabicus.prospring3.tutorials.ch7.namespace.aop.aspectj;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created with IntelliJ IDEA.
 * User: schcrabicus
 * Date: 23.01.13
 * Time: 7:57
 * To change this template use File | Settings | File Templates.
 */
public class Launcher {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:**/ch7/namespace/aop/aspectj/spring-config.xml");

        MyBean bean = context.getBean("myBean", MyBean.class);
        bean.execute();
    }
}

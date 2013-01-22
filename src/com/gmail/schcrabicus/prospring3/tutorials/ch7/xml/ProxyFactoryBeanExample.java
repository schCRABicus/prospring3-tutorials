package com.gmail.schcrabicus.prospring3.tutorials.ch7.xml;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created with IntelliJ IDEA.
 * User: schcrabicus
 * Date: 22.01.13
 * Time: 7:43
 * To change this template use File | Settings | File Templates.
 */
public class ProxyFactoryBeanExample {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:**/ch7/xml/spring-app-config.xml");

        MyBean bean1 = (MyBean) context.getBean("myBean1");
        MyBean bean2 = (MyBean) context.getBean("myBean2");

        System.out.println("Executing Bean 1 :");
        bean1.execute();

        System.out.println("Executing Bean 2 :");
        bean2.execute();
    }
}

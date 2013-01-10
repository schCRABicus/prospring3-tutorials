package com.gmail.schcrabicus.prospring3.tutorials.ch4.lazyinit;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created with IntelliJ IDEA.
 * User: schcrabicus
 * Date: 08.01.13
 * Time: 8:18
 * To change this template use File | Settings | File Templates.
 */
public class Launcher {

    public static void main(String[] args){
        System.out.println("Retrieving ApplicationContext...");
        ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:**/spring-app-config-lazyinit.xml");
        System.out.println("ApplicationContext retrieved !!");

        System.out.println("Retrieving regular bean...");
        RegularBean b1 = ctx.getBean("regular", RegularBean.class);
        System.out.println("Retrieving lazy init bean...");
        LazyInitBean b2 = ctx.getBean("lazy", LazyInitBean.class);
        System.out.println(b1);
        System.out.println(b2);

        System.out.println("Retrieving prototype scoped regular bean...");
        RegularBean b3 = ctx.getBean("regularPrototype", RegularBean.class);
        System.out.println("Retrieving prototype scoped lazy init bean...");
        LazyInitBean b4 = ctx.getBean("lazyPrototype", LazyInitBean.class);
        System.out.println(b3);
        System.out.println(b4);
    }
}

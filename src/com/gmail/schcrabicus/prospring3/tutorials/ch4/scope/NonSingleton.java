package com.gmail.schcrabicus.prospring3.tutorials.ch4.scope;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane;

/**
 * Created with IntelliJ IDEA.
 * User: schcrabicus
 * Date: 08.01.13
 * Time: 8:04
 * To change this template use File | Settings | File Templates.
 */
public class NonSingleton {

    public static void main(String[] args){
        ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:**/spring-app-config-nonsingleton.xml");

        String s1 = ctx.getBean("nonSingleton", String.class);
        String s2 = ctx.getBean("nonSingleton", String.class);

        System.out.println("Identity Equal ? : " + (s1 == s2));
        System.out.println("Value Equal ? : " + (s1.equals(s2)));
        System.out.println(s1);
        System.out.println(s2);
    }
}

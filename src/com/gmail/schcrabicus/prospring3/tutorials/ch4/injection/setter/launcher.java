package com.gmail.schcrabicus.prospring3.tutorials.ch4.injection.setter;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created with IntelliJ IDEA.
 * User: schcrabicus
 * Date: 02.01.13
 * Time: 8:51
 * To change this template use File | Settings | File Templates.
 */
public class launcher {

    public static void main(String []args){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:**/spring-application-xml.xml");

        MessageRenderer messageRenderer = applicationContext.getBean("messageRenderer", MessageRenderer.class);
        System.out.println("Setter injection : ");
        messageRenderer.render();

    }
}

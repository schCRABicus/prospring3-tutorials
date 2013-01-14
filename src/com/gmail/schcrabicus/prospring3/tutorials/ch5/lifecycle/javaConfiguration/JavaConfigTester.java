package com.gmail.schcrabicus.prospring3.tutorials.ch5.lifecycle.javaConfiguration;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created with IntelliJ IDEA.
 * User: schcrabicus
 * Date: 14.01.13
 * Time: 7:46
 * To change this template use File | Settings | File Templates.
 */
public class JavaConfigTester {

    public static void main(String[] args){

        ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);

        MessageRenderer renderer = ctx.getBean("messageRenderer", MessageRenderer.class);
        renderer.render();
    }
}

package com.gmail.schcrabicus.prospring3.tutorials.ch5.lifecycle.environment;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.core.env.*;

import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: schcrabicus
 * Date: 14.01.13
 * Time: 8:39
 * To change this template use File | Settings | File Templates.
 */
public class EnvironmentSample {

    public static void main(String[] args){

        //ApplicationContext ctx = new ClassPathXmlApplicationContext();
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.refresh();

        ConfigurableEnvironment env = ctx.getEnvironment();
        MutablePropertySources propertySources = env.getPropertySources();

        Map appMap = new HashMap();
        appMap.put("application.home", "/etc/prospring3/home");
        propertySources.addLast(new MapPropertySource("PROSPRING3_MAP", appMap));
        System.out.println("user.home: " + System.getProperty("user.home"));
        System.out.println("JAVA_HOME: " + System.getenv("JAVA_HOME"));
        System.out.println("user.home: " + env.getProperty("user.home"));
        System.out.println("JAVA_HOME: " + env.getProperty("JAVA_HOME"));
        System.out.println("application.home: " + env.getProperty("application.home"));

    }


}

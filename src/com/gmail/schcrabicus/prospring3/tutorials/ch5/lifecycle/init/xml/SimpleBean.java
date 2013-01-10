package com.gmail.schcrabicus.prospring3.tutorials.ch5.lifecycle.init.xml;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created with IntelliJ IDEA.
 * User: schcrabicus
 * Date: 08.01.13
 * Time: 8:27
 * To change this template use File | Settings | File Templates.
 */
public class SimpleBean {

    private static final String DEFAULT_NAME = "Leha Dureha";

    private String name = null;

    private int age = Integer.MIN_VALUE;

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void init() {
        System.out.println("Initializing bean...");

        if (name == null ){
            System.out.println("Using default name...");
            name = SimpleBean.DEFAULT_NAME;
        }
        if ( age == Integer.MIN_VALUE ){
            throw new IllegalArgumentException("You must set the age...");
        }
    }

    @Override
    public String toString() {
        return "SimpleBean{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public static void main(String[] args){
        ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:**/lifecycle/init/xml/spring-app.xml");

        getBean("simpleBean1", ctx);
        getBean("simpleBean2", ctx);
        getBean("simpleBean3", ctx);
    }

    public static SimpleBean getBean (String beanName, ApplicationContext ctx){
        try {
            SimpleBean simpleBean = ctx.getBean(beanName, SimpleBean.class);
            System.out.println(simpleBean);
            return simpleBean;
        } catch (IllegalArgumentException ex){
            System.out.println("An error occurred in bean configuration : " + ex.getMessage());
            return null;
        }
    }
}

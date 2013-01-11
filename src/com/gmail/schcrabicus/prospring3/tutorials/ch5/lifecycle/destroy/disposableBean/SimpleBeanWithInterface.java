package com.gmail.schcrabicus.prospring3.tutorials.ch5.lifecycle.destroy.disposableBean;

import org.springframework.beans.factory.BeanCreationException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

/**
 * Created with IntelliJ IDEA.
 * User: schcrabicus
 * Date: 08.01.13
 * Time: 8:27
 * To change this template use File | Settings | File Templates.
 */
public class SimpleBeanWithInterface implements InitializingBean, DisposableBean, BeanNameAware {

    private static final String DEFAULT_NAME = "Leha Dureha";

    private String name = null;

    private String beanName = null;

    private int age = Integer.MIN_VALUE;

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "SimpleBeanWithInterface{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public static void main(String[] args){
        //ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:**/lifecycle/destroy/xml/spring-app.xml");
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("classpath:**/lifecycle/destroy/disposableBean/spring-app.xml");
        ctx.registerShutdownHook(); //shutdown hook registered; there is no need to call for destroy() method;
        ctx.refresh();

        getBean("simpleBean1", ctx);
        getBean("simpleBean2", ctx);
        getBean("simpleBean3", ctx);

        System.out.println("Destroying ApplicationContext....");
        //ctx.destroy();
    }

    public static SimpleBeanWithInterface getBean (String beanName, ApplicationContext ctx){
        try {
            SimpleBeanWithInterface simpleBean = ctx.getBean(beanName, SimpleBeanWithInterface.class);
            System.out.println(simpleBean);
            return simpleBean;
        } catch (BeanCreationException ex){
            System.out.println("An error occurred in bean configuration : " + ex.getMessage());
            return null;
        }
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("Initializing bean...");

        if (name == null ){
            System.out.println("Using default name...");
            name = SimpleBeanWithInterface.DEFAULT_NAME;
        }
        if ( age == Integer.MIN_VALUE ){
            throw new IllegalArgumentException("You must set the age...");
        }
    }

    @Override
    public void destroy(){
        System.out.println("destroying bean " + beanName + "...");
    }

    @Override
    public void setBeanName(String s) {
        this.beanName = s;
    }
}

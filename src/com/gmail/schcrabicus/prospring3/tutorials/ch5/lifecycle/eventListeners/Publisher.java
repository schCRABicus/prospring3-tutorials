package com.gmail.schcrabicus.prospring3.tutorials.ch5.lifecycle.eventListeners;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

/**
 * Created with IntelliJ IDEA.
 * User: schcrabicus
 * Date: 13.01.13
 * Time: 9:13
 * To change this template use File | Settings | File Templates.
 */
@Component
public class Publisher implements ApplicationContextAware {

    private ApplicationContext ctx;

    public static void main(String[] args){
        ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:**/ch5/lifecycle/eventListeners/spring-app.xml");

        Publisher publisher = ctx.getBean("publisher", Publisher.class);
        publisher.publish("Custom event ...");
        publisher.publish("Second message");
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.ctx = applicationContext;
    }

    public void publish(String msg){
        ctx.publishEvent(new MessageEvent(this, msg));
    }
}

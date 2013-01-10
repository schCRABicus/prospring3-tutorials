package com.gmail.schcrabicus.prospring3.tutorials.ch4.value.injection.spel_annotation;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

/**
 * Created with IntelliJ IDEA.
 * User: schcrabicus
 * Date: 02.01.13
 * Time: 9:45
 * To change this template use File | Settings | File Templates.
 */
@Service
public class InjectSimpleSpel {

    @Value("#{injectSimpleConfig.name}")
    private String name;

    @Value("#{injectSimpleConfig.age}")
    private int age;

    @Value("#{injectSimpleConfig.height}")
    private float height;

    @Value("#{injectSimpleConfig.programmer}")
    private boolean programmer;

    @Value("#{injectSimpleConfig.ageInSeconds}")
    private Long ageInSeconds;

    public static void main(String[] args){
        ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:com/gmail/schcrabicus/prospring3/tutorials/ch4/value/injection/spel_annotation/spring-application-config.xml");

        InjectSimpleSpel injectSimple = ctx.getBean("injectSimpleSpel", InjectSimpleSpel.class);
        System.out.println(injectSimple);
    }

    @Override
    public String toString() {
        return "InjectSimple {" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", height=" + height +
                ", programmer=" + programmer +
                ", ageInSeconds=" + ageInSeconds +
                '}';
    }
}

package com.gmail.schcrabicus.prospring3.tutorials.ch7.xml.intriduction;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created with IntelliJ IDEA.
 * User: schcrabicus
 * Date: 22.01.13
 * Time: 8:09
 * To change this template use File | Settings | File Templates.
 */
public class IntroductionExample {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:**/ch7/xml/intriduction/spring-app-config.xml");

        TargetBean bean = context.getBean("bean", TargetBean.class);

        // test interfaces
        System.out.println("Is TargetBean?: " + (bean instanceof TargetBean));
        System.out.println("Is IDecorator?: " + (bean instanceof IDecorator));

        bean.foo();
        ((IDecorator) bean).executeAdditionalFunctionality();
    }
}

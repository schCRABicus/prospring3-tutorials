package com.gmail.schcrabicus.prospring3.tutorials.ch5.lifecycle.propertyEditors.custom;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

/**
 * Created with IntelliJ IDEA.
 * User: schcrabicus
 * Date: 13.01.13
 * Time: 8:32
 * To change this template use File | Settings | File Templates.
 */
@Component("example")
public class CustomEditorExample {

    @Value("Nickolai Lushchitskiy")
    private Name name;

    public Name getName() {
        return name;
    }

    public void setName(Name name) {
        this.name = name;
    }

    public static void main(String[] args){
        ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:**/ch5/lifecycle/propertyEditors/custom/spring-app.xml");

        CustomEditorExample bean = ctx.getBean("example", CustomEditorExample.class);
        System.out.println(bean.getName());
    }
}

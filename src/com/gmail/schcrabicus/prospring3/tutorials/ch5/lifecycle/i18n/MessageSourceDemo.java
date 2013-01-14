package com.gmail.schcrabicus.prospring3.tutorials.ch5.lifecycle.i18n;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Locale;

/**
 * Created with IntelliJ IDEA.
 * User: schcrabicus
 * Date: 13.01.13
 * Time: 8:47
 * To change this template use File | Settings | File Templates.
 */
public class MessageSourceDemo {

    public static void main(String[] args){
        ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:**/lifecycle/i18n/spring-app.xml");

        Locale en = Locale.ENGLISH;
        Locale ru = new Locale("ru", "RU");

        System.out.println("Printing msg content : ");
        System.out.println("en : " + ctx.getMessage("msg",  null, "not found : (", en));
        System.out.println("ru : " + ctx.getMessage("msg",  null, "not found : (", ru));
        System.out.println("-----------------------");
        System.out.println("");

        System.out.println("Printing greeting content : ");
        System.out.println("en : " + ctx.getMessage("greeting",  new Object[] {"Kolya", "Lushchitskiy"}, "not found : (", en));
        System.out.println("ru : " + ctx.getMessage("greeting",  new Object[] {"Коля", "Лущицкий"}, "not found : (", ru));
        System.out.println("-----------------------");
        System.out.println("");
    }
}

package com.gmail.schcrabicus.prospring3.tutorials.ch5.lifecycle.profiles;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: schcrabicus
 * Date: 14.01.13
 * Time: 8:00
 * To change this template use File | Settings | File Templates.
 */
public class ProfileXmlConfigExample {

    public static final String PROFILE = "highschool"; // "highschool" "kindergarten"

    public static void main(String[] args){
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();

        ctx.getEnvironment().setActiveProfiles(ProfileXmlConfigExample.PROFILE);
        ctx.load("classpath:**/ch5/lifecycle/profiles/*-config.xml");
        ctx.refresh();

        FoodProviderService foodProviderService =
                ctx.getBean("foodProviderService", FoodProviderService.class);
        List<Food> lunchSet = foodProviderService.provideLaunchSet();
        for (Food food: lunchSet) {
            System.out.println("Food: " + food.getName());
        }
    }
}

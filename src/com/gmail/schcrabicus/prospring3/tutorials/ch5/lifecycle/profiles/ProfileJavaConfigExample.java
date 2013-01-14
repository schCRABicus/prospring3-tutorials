package com.gmail.schcrabicus.prospring3.tutorials.ch5.lifecycle.profiles;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: schcrabicus
 * Date: 14.01.13
 * Time: 8:26
 * To change this template use File | Settings | File Templates.
 */
public class ProfileJavaConfigExample {

    public static final String PROFILE = "highschool"; // "highschool" "kindergarten"

    public static void main(String[] args){

        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
        ctx.getEnvironment().setActiveProfiles(ProfileJavaConfigExample.PROFILE);
        ctx.register(KindergatenConfig.class, HighschoolConfig.class);
        ctx.refresh();

        FoodProviderService foodProviderService =
                ctx.getBean("foodProviderService", FoodProviderService.class);
        List<Food> lunchSet = foodProviderService.provideLaunchSet();
        for (Food food: lunchSet) {
            System.out.println("Food: " + food.getName());
        }

    }
}

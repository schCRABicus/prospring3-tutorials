package com.gmail.schcrabicus.prospring3.tutorials.ch5.lifecycle.profiles;

import com.gmail.schcrabicus.prospring3.tutorials.ch5.lifecycle.profiles.highschool.FoodProviderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 * Created with IntelliJ IDEA.
 * User: schcrabicus
 * Date: 14.01.13
 * Time: 8:25
 * To change this template use File | Settings | File Templates.
 */
@Configuration
@Profile("highschool")
public class HighschoolConfig {

    @Bean
    public FoodProviderService foodProviderService(){
        return new FoodProviderServiceImpl();
    }
}

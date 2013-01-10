package com.gmail.schcrabicus.prospring3.tutorials.ch4.value.injection.spel_annotation;

import org.springframework.stereotype.Component;

/**
 * Created with IntelliJ IDEA.
 * User: schcrabicus
 * Date: 03.01.13
 * Time: 8:17
 * To change this template use File | Settings | File Templates.
 */
@Component
public class InjectSimpleConfig {

    private String name = "Nickolay";

    private int age = 23;

    private float height = 1.76f;

    private boolean programmer = true;

    private Long ageInSeconds = 1000000000000000l;

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public float getHeight() {
        return height;
    }

    public boolean isProgrammer() {
        return programmer;
    }

    public Long getAgeInSeconds() {
        return ageInSeconds;
    }
}

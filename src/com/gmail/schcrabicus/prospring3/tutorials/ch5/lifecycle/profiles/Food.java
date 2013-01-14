package com.gmail.schcrabicus.prospring3.tutorials.ch5.lifecycle.profiles;

/**
 * Created with IntelliJ IDEA.
 * User: schcrabicus
 * Date: 14.01.13
 * Time: 7:52
 * To change this template use File | Settings | File Templates.
 */
public class Food {

    private String name;

    public Food(){

    }

    public Food(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

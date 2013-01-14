package com.gmail.schcrabicus.prospring3.tutorials.ch5.lifecycle.profiles.kindergarten;

import com.gmail.schcrabicus.prospring3.tutorials.ch5.lifecycle.profiles.Food;
import com.gmail.schcrabicus.prospring3.tutorials.ch5.lifecycle.profiles.FoodProviderService;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: schcrabicus
 * Date: 14.01.13
 * Time: 7:54
 * To change this template use File | Settings | File Templates.
 */
public class FoodProviderServiceImpl implements FoodProviderService {

    @Override
    public List<Food> provideLaunchSet() {
        List<Food> launchSet = new ArrayList<Food>();

        launchSet.add(new Food("Milk"));
        launchSet.add(new Food("Biscuits"));

        return launchSet;
    }
}

package com.gmail.schcrabicus.prospring3.tutorials.ch6.aop.advice.afterReturning;

import java.util.Random;

/**
 * Created with IntelliJ IDEA.
 * User: schcrabicus
 * Date: 16.01.13
 * Time: 7:58
 * To change this template use File | Settings | File Templates.
 */
public class TargetObject {

    public int doCalculations(){
        Random rand = new Random();
        int rand1 = rand.nextInt(100);
        int rand2 = rand.nextInt(100);
        System.out.println(rand1 + " + " + rand2 + " = " + (rand1+ rand2));
        return rand1 + rand2;
    }

    public int getValue(){
        Random rand = new Random();
        return rand.nextInt(3);
    }
}

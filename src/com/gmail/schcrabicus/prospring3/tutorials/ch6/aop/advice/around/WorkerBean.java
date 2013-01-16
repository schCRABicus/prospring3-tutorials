package com.gmail.schcrabicus.prospring3.tutorials.ch6.aop.advice.around;

/**
 * Created with IntelliJ IDEA.
 * User: schcrabicus
 * Date: 16.01.13
 * Time: 8:26
 * To change this template use File | Settings | File Templates.
 */
public class WorkerBean {

    public void doSomeWork(int noOfTimes) {
        for(int x = 0; x < noOfTimes; x++) {
            work();
        }
    }

    private void work() {
        System.out.print("");
    }

}

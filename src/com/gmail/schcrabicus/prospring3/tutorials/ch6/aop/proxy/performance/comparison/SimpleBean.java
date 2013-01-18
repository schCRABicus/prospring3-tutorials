package com.gmail.schcrabicus.prospring3.tutorials.ch6.aop.proxy.performance.comparison;

/**
 * Created with IntelliJ IDEA.
 * User: schcrabicus
 * Date: 18.01.13
 * Time: 8:03
 * To change this template use File | Settings | File Templates.
 */
public class SimpleBean implements ISimpleBean {

    private long dummy = 0;

    @Override
    public void advised() {
        dummy = System.currentTimeMillis();
    }

    @Override
    public void unadvised() {
        dummy = System.currentTimeMillis();
    }
}

package com.gmail.schcrabicus.prospring3.tutorials.ch7.xml;

/**
 * Created with IntelliJ IDEA.
 * User: schcrabicus
 * Date: 22.01.13
 * Time: 7:26
 * To change this template use File | Settings | File Templates.
 */
public class MyBean {

    private MyDependency myDependency;

    public void setMyDependency(MyDependency myDependency) {
        this.myDependency = myDependency;
    }

    public void execute(){
        myDependency.foo();
        myDependency.bar();
    }
}

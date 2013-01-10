package com.gmail.schcrabicus.prospring3.tutorials.ch4.method.injection;

/**
 * Created with IntelliJ IDEA.
 * User: schcrabicus
 * Date: 03.01.13
 * Time: 9:10
 * To change this template use File | Settings | File Templates.
 */
public abstract class AbstractLookupDemoBean implements DemoBean {

    @Override
    public abstract MyHelper getMyHelper();

    @Override
    public void someOperation() {
        getMyHelper().doSomethingHelpful();
    }
}

package com.gmail.schcrabicus.prospring3.tutorials.ch4.method.injection;

import org.springframework.beans.factory.InitializingBean;

/**
 * Created with IntelliJ IDEA.
 * User: schcrabicus
 * Date: 03.01.13
 * Time: 9:08
 * To change this template use File | Settings | File Templates.
 */
public class StandardLookupDemoBean implements DemoBean, InitializingBean {

    private MyHelper myHelper;

    @Override
    public MyHelper getMyHelper() {
        return myHelper;
    }

    public void setMyHelper(MyHelper myHelper) {
        this.myHelper = myHelper;
    }

    @Override
    public void someOperation() {
        myHelper.doSomethingHelpful();
    }

    @Override
    public void afterPropertiesSet() throws Exception {

        if (myHelper == null){
            throw new RuntimeException("myHelper bean is not injected");
        }
    }
}

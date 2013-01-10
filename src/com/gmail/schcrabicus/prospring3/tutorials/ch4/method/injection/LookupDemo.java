package com.gmail.schcrabicus.prospring3.tutorials.ch4.method.injection;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.util.StopWatch;

/**
 * Created with IntelliJ IDEA.
 * User: schcrabicus
 * Date: 03.01.13
 * Time: 9:12
 * To change this template use File | Settings | File Templates.
 */
public class LookupDemo {

    public static void main(String[] args){
        ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:**/spring-app-config-method-injection.xml");

        DemoBean abstractBean = ctx.getBean("abstractLookupBean", DemoBean.class);
        DemoBean standardBean = ctx.getBean("standardLookupBean", DemoBean.class);

        displayInfo(abstractBean);
        displayInfo(standardBean);
    }

    public static void displayInfo(DemoBean bean){
        System.out.println("Displaying info for " + bean.getClass().getSimpleName());

        MyHelper helper1 = bean.getMyHelper();
        MyHelper helper2 = bean.getMyHelper();

        System.out.println("Helper instances the same ? : " + (helper1 == helper2));
        StopWatch stopWatch = new StopWatch();
        stopWatch.start("lookupDemo");
        for (int x = 0; x < 10000; x++){
            MyHelper helper = bean.getMyHelper();
            helper.doSomethingHelpful();
        }
        stopWatch.stop();
        System.out.println("10000 gets took " + stopWatch.getTotalTimeMillis() + " ms");
    }
}

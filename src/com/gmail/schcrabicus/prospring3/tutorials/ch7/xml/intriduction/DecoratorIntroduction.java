package com.gmail.schcrabicus.prospring3.tutorials.ch7.xml.intriduction;

import org.springframework.aop.support.DelegatingIntroductionInterceptor;

/**
 * Created with IntelliJ IDEA.
 * User: schcrabicus
 * Date: 22.01.13
 * Time: 8:00
 * To change this template use File | Settings | File Templates.
 */
public class DecoratorIntroduction extends DelegatingIntroductionInterceptor implements IDecorator {
    @Override
    public void executeAdditionalFunctionality() {
        System.out.println(" >> Executed mixedmethod !!!");
    }

}

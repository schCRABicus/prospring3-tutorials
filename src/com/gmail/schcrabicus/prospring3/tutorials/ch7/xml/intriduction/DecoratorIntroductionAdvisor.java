package com.gmail.schcrabicus.prospring3.tutorials.ch7.xml.intriduction;

import org.aopalliance.aop.Advice;
import org.springframework.aop.support.DefaultIntroductionAdvisor;

/**
 * Created with IntelliJ IDEA.
 * User: schcrabicus
 * Date: 22.01.13
 * Time: 8:01
 * To change this template use File | Settings | File Templates.
 */
public class DecoratorIntroductionAdvisor extends DefaultIntroductionAdvisor {


    public DecoratorIntroductionAdvisor() {
        super(new DecoratorIntroduction());
    }
}

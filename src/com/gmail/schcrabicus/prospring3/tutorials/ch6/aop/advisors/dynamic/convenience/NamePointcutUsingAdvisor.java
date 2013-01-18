package com.gmail.schcrabicus.prospring3.tutorials.ch6.aop.advisors.dynamic.convenience;

import com.gmail.schcrabicus.prospring3.tutorials.ch6.aop.advisors.dynamic.nameMatching.NameBean;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.NameMatchMethodPointcutAdvisor;

/**
 * Created with IntelliJ IDEA.
 * User: schcrabicus
 * Date: 18.01.13
 * Time: 7:51
 * To change this template use File | Settings | File Templates.
 */
public class NamePointcutUsingAdvisor {

    public static void main(String[] args) {
        NameBean target = new NameBean();

        NameMatchMethodPointcutAdvisor advisor = new NameMatchMethodPointcutAdvisor(new AroundAdvice());
        advisor.addMethodName("foo");
        advisor.addMethodName("bar");

        ProxyFactory proxyFactory = new ProxyFactory();
        proxyFactory.setTarget(target);
        proxyFactory.addAdvisor(advisor);

        NameBean bean = (NameBean) proxyFactory.getProxy();
        bean.foo(200);
        bean.yup();
        bean.bar();
        bean.foo();
    }
}

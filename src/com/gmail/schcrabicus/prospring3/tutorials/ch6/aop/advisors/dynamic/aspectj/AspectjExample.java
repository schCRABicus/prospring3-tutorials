package com.gmail.schcrabicus.prospring3.tutorials.ch6.aop.advisors.dynamic.aspectj;

import com.gmail.schcrabicus.prospring3.tutorials.ch6.aop.advisors.dynamic.regexp.ArooundAdvice;
import org.aopalliance.aop.Advice;
import org.springframework.aop.Advisor;
import org.springframework.aop.aspectj.AspectJExpressionPointcut;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.DefaultPointcutAdvisor;

/**
 * Created with IntelliJ IDEA.
 * User: schcrabicus
 * Date: 17.01.13
 * Time: 8:42
 * To change this template use File | Settings | File Templates.
 */
public class AspectjExample {

    public static void main(String[] args) {
        AspectjBean target = new AspectjBean();

        AspectJExpressionPointcut pointcut = new AspectJExpressionPointcut();
        //pointcut.setExpression("execution(* foo*(..))"); // return any type, method's name starts with foo and has any arguments;
        pointcut.setExpression("execution(* foo*(int))"); // return any type, method's name starts with foo and has int argument;
        Advice advice = new ArooundAdvice();
        Advisor advisor = new DefaultPointcutAdvisor(pointcut, advice);

        // create the proxy
        ProxyFactory pf = new ProxyFactory();
        pf.setTarget(target);
        pf.addAdvisor(advisor);
        AspectjBean proxy = (AspectjBean) pf.getProxy();
        proxy.foo1();
        proxy.foo2();
        proxy.foo2(20);
        proxy.bar();
    }
}

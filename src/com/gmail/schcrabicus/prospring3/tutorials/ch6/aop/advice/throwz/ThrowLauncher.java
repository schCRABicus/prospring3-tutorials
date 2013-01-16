package com.gmail.schcrabicus.prospring3.tutorials.ch6.aop.advice.throwz;

import org.springframework.aop.framework.ProxyFactory;

/**
 * Created with IntelliJ IDEA.
 * User: schcrabicus
 * Date: 16.01.13
 * Time: 8:48
 * To change this template use File | Settings | File Templates.
 */
public class ThrowLauncher {

    public static void main(String[] args) {
        ErrorBean bean = getErrorBean();

        try{
            bean.errorProneMethod();
        } catch(Exception ignored){
            System.out.println("-----ignored exception----");
        }

        try{
            bean.otherErrorProneMethod();
        } catch(Exception ignored) {
            System.out.println("-----ignored exception----");
        }
    }

    private static ErrorBean getErrorBean(){
        ErrorBean target = new ErrorBean();

        ProxyFactory proxyFactory = new ProxyFactory();
        proxyFactory.setTarget(target);
        proxyFactory.addAdvice(new ThrowAdvice());

        return (ErrorBean) proxyFactory.getProxy();
    }
}

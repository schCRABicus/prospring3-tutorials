package com.gmail.schcrabicus.prospring3.tutorials.ch6.aop.advice.before.secure;

import org.springframework.aop.framework.ProxyFactory;

/**
 * Created with IntelliJ IDEA.
 * User: schcrabicus
 * Date: 15.01.13
 * Time: 8:31
 * To change this template use File | Settings | File Templates.
 */
public class SecureExample {

    public static void main(String[] args) {
        // get the security manager
        SecurityManager mgr = new SecurityManager();
        // get the bean
        SecureBean bean = getSecureBean();

        // try as Kolya
        try {
            mgr.login(new UserInfo("Kolya", "pwd"));
            bean.writeSecuredMessage();
        } catch (SecurityException ex) {
            System.out.println("Something strange... Kolya failed to login...");
        } finally{
            mgr.logout();
        }

        // try as Vova
        try {
            mgr.login(new UserInfo("Vova", "pwd"));
            bean.writeSecuredMessage();
        } catch(SecurityException ex) {
            System.out.println("Exception Caught: " + ex.getMessage());
        } finally {
            mgr.logout();
        }
        // try with no credentials
        try {
            bean.writeSecuredMessage();
        } catch(SecurityException ex) {
            System.out.println("Exception Caught: " + ex.getMessage());
        }
    }

    private static SecureBean getSecureBean(){
        SecureBean target = new SecureBean();

        ProxyFactory proxyFactory = new ProxyFactory();
        proxyFactory.setTarget(target);
        proxyFactory.addAdvice(new SecurityAdvice());

        SecureBean secureBean = (SecureBean) proxyFactory.getProxy();
        return secureBean;
    }
}

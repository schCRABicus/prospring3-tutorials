package com.gmail.schcrabicus.prospring3.tutorials.ch5.lifecycle.factoryBeans;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.InitializingBean;

import java.security.MessageDigest;

/**
 * Created with IntelliJ IDEA.
 * User: schcrabicus
 * Date: 11.01.13
 * Time: 7:42
 * To change this template use File | Settings | File Templates.
 */
public class MessageDigestFactoryBean implements FactoryBean<MessageDigest>, InitializingBean {

    private String algorithmName = "MD5";

    private MessageDigest messageDigest;

    @Override
    public MessageDigest getObject() throws Exception {
        return messageDigest;
    }

    @Override
    public Class<?> getObjectType() {
        return MessageDigest.class;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        messageDigest = MessageDigest.getInstance(algorithmName);
    }

    public void setAlgorithmName(String algorithmName) {
        this.algorithmName = algorithmName;
    }
}

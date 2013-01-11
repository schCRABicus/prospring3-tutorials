package com.gmail.schcrabicus.prospring3.tutorials.ch5.lifecycle.factoryBeans.xml;

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
public class MessageDigestFactory{

    private String algorithmName = "MD5";

    public void setAlgorithmName(String algorithmName) {
        this.algorithmName = algorithmName;
    }

    public MessageDigest createInstance() throws Exception{
        return MessageDigest.getInstance(algorithmName);
    }
}

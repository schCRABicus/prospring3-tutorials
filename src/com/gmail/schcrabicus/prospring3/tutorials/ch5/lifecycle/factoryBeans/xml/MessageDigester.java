package com.gmail.schcrabicus.prospring3.tutorials.ch5.lifecycle.factoryBeans.xml;

import java.security.MessageDigest;

/**
 * Created with IntelliJ IDEA.
 * User: schcrabicus
 * Date: 11.01.13
 * Time: 7:46
 * To change this template use File | Settings | File Templates.
 */
public class MessageDigester {

    private MessageDigest digest1;
    private MessageDigest digest2;

    public void setDigest1(MessageDigest digest1) {
        this.digest1 = digest1;
    }

    public void setDigest2(MessageDigest digest2) {
        this.digest2 = digest2;
    }

    public void digest(String msg) {
        System.out.println("Using digest1");
        digest(msg, digest1);
        System.out.println("Using digest2");
        digest(msg, digest2);
    }

    private void digest(String msg, MessageDigest digest) {
        System.out.println("Using algorithm: " + digest.getAlgorithm());
        digest.reset();
        byte[] bytes = msg.getBytes();
        byte[] out = digest.digest(bytes);
        System.out.println(out);
    }
}

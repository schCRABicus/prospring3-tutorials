package com.gmail.schcrabicus.prospring3.tutorials.ch10.jpa2.spring.data.auditor;

import org.springframework.data.domain.AuditorAware;

/**
 * Created with IntelliJ IDEA.
 * User: schcrabicus
 * Date: 05.02.13
 * Time: 8:46
 * To change this template use File | Settings | File Templates.
 */
public class AuditorAwareBean implements AuditorAware<String> {

    @Override
    public String getCurrentAuditor() {
        return "prospring3";
    }
}

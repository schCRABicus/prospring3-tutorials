package com.gmail.schcrabicus.prospring3.tutorials.ch10.jpa2.hibernate.envers.auditor;

import org.springframework.data.domain.AuditorAware;

/**
 * Created with IntelliJ IDEA.
 * User: schcrabicus
 * Date: 07.02.13
 * Time: 7:49
 * To change this template use File | Settings | File Templates.
 */
public class AuditorAwareBean implements AuditorAware<String> {

    @Override
    public String getCurrentAuditor() {
        return "Kolya";
    }
}

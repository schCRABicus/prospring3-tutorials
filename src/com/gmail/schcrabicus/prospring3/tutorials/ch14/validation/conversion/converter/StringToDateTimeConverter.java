package com.gmail.schcrabicus.prospring3.tutorials.ch14.validation.conversion.converter;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

/**
 * Created with IntelliJ IDEA.
 * User: schcrabicus
 * Date: 19.02.13
 * Time: 7:44
 * To change this template use File | Settings | File Templates.
 */
/*@Component*/
public class StringToDateTimeConverter implements Converter<String, DateTime>, InitializingBean {

    @Value("#{appProps['date.format.pattern']}")
    private String DEFAULT_DATE_PATTERN;

    private DateTimeFormatter dateTimeFormatter;

    @Autowired(required = false)
    private String datePattern;

    @Override
    public DateTime convert(String s) {
        return dateTimeFormatter.parseDateTime(s);
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("DEFAULT_DATE_PATTERN = " + DEFAULT_DATE_PATTERN);
        if ( this.datePattern == null ){
            this.datePattern = DEFAULT_DATE_PATTERN;
        }
        this.dateTimeFormatter = DateTimeFormat.forPattern(datePattern);
    }

    public String getDatePattern() {
        return datePattern;
    }

    public void setDatePattern(String datePattern) {
        this.datePattern = datePattern;
    }
}

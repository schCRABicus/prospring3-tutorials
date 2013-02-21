package com.gmail.schcrabicus.prospring3.tutorials.ch14.validation.conversion.converter;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;
import org.springframework.format.support.FormattingConversionServiceFactoryBean;

import java.text.ParseException;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * User: schcrabicus
 * Date: 20.02.13
 * Time: 7:26
 * To change this template use File | Settings | File Templates.
 */
public class ApplicationConversionServiceFactory extends FormattingConversionServiceFactoryBean {

    private static final String DEFAULT_DATE_PATTERN = "yyyy-MM-dd";
    private DateTimeFormatter dateFormat;
    private String datePattern = DEFAULT_DATE_PATTERN;
    private Set<Formatter<?>> formatters = new HashSet<Formatter<?>>();

    public String getDatePattern() {
        return datePattern;
    }

    @Autowired(required=false)
    public void setDatePattern(String datePattern) {
        this.datePattern = datePattern;
    }

    @Override
    public void afterPropertiesSet() {
        dateFormat = DateTimeFormat.forPattern(datePattern);
        formatters.add(getDateTimeFormatter());
        setFormatters(formatters);
    }

    public Formatter<DateTime> getDateTimeFormatter() {
        return new Formatter<DateTime>() {
            public DateTime parse(String dateTimeString, Locale locale) throws ParseException {
                System.out.println("Parsing date string: " + dateTimeString);
                return dateFormat.parseDateTime(dateTimeString);
            }
            public String print(DateTime dateTime, Locale locale) {
                System.out.println("Formatting datetime: " + dateTime);
                return dateFormat.print(dateTime);
            }
        };
    }
}

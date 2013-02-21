package com.gmail.schcrabicus.prospring3.tutorials.ch14.validation.conversion.editor;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import java.beans.PropertyEditorSupport;

/**
 * Created with IntelliJ IDEA.
 * User: schcrabicus
 * Date: 19.02.13
 * Time: 7:29
 * To change this template use File | Settings | File Templates.
 */
public class DateTimeEditor extends PropertyEditorSupport {

    private DateTimeFormatter dateTimeFormatter;

    public DateTimeEditor(String dateTimePattern){
        this.dateTimeFormatter = DateTimeFormat.forPattern(dateTimePattern);
    }

    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        setValue(DateTime.parse(text, dateTimeFormatter));
    }
}

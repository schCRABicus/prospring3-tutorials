package com.gmail.schcrabicus.prospring3.tutorials.ch5.lifecycle.propertyEditors.custom;

import java.beans.PropertyEditorSupport;

/**
 * Created with IntelliJ IDEA.
 * User: schcrabicus
 * Date: 13.01.13
 * Time: 8:25
 * To change this template use File | Settings | File Templates.
 */
public class NamePropertyEditor extends PropertyEditorSupport {

    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        String[] name = text.split("\\s");

        if ( name.length > 1 ){
            Name result = new Name(name[0], name[1]);
            setValue(result);
        } else {
            throw new IllegalArgumentException("Name has to consist of at least two strings, separated by space.");
        }
    }
}

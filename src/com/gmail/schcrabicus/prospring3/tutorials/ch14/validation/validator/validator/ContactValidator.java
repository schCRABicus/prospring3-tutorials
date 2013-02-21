package com.gmail.schcrabicus.prospring3.tutorials.ch14.validation.validator.validator;

import com.gmail.schcrabicus.prospring3.tutorials.ch14.validation.validator.domain.Contact;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 * Created with IntelliJ IDEA.
 * User: schcrabicus
 * Date: 20.02.13
 * Time: 7:41
 * To change this template use File | Settings | File Templates.
 */
@Component("contactValidator")
public class ContactValidator implements Validator {

    @Override
    public boolean supports(Class<?> aClass) {
        return Contact.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        ValidationUtils.rejectIfEmpty( errors , "firstName" , "firstName.empty");
    }
}

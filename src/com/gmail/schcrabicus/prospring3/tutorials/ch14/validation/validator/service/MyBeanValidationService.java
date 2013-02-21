package com.gmail.schcrabicus.prospring3.tutorials.ch14.validation.validator.service;

import com.gmail.schcrabicus.prospring3.tutorials.ch14.validation.validator.domain.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * User: schcrabicus
 * Date: 20.02.13
 * Time: 8:01
 * To change this template use File | Settings | File Templates.
 */
@Service("myBeanValidationService")
public class MyBeanValidationService {

    @Autowired
    private Validator validator;

    public Set<ConstraintViolation<Customer>> validateCustomer(Customer customer){
        return validator.validate(customer);
    }
}

package com.gmail.schcrabicus.prospring3.tutorials.ch14.validation.validator.validator.custom;

import com.gmail.schcrabicus.prospring3.tutorials.ch14.validation.validator.domain.Customer;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * Created with IntelliJ IDEA.
 * User: schcrabicus
 * Date: 21.02.13
 * Time: 7:50
 * To change this template use File | Settings | File Templates.
 */
public class IndividualCustomerValidator implements ConstraintValidator<CheckIndividualCustomer, Customer> {

    @Override
    public void initialize(CheckIndividualCustomer checkIndividualCustomer) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public boolean isValid(Customer customer, ConstraintValidatorContext constraintValidatorContext) {
        boolean result = true;

        if (customer.getCustomerType() != null &&
                (customer.isIndividualCustomer()
                        && (customer.getLastName() == null ||
                        customer.getGender() == null))
                ) {
            result = false;
        }

        return result;
    }
}

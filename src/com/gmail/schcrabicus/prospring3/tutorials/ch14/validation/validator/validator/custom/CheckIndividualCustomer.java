package com.gmail.schcrabicus.prospring3.tutorials.ch14.validation.validator.validator.custom;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

/**
 * Created with IntelliJ IDEA.
 * User: schcrabicus
 * Date: 21.02.13
 * Time: 7:48
 * To change this template use File | Settings | File Templates.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Constraint(validatedBy = IndividualCustomerValidator.class)
@Documented
public @interface CheckIndividualCustomer {

    String message() default "Individual customer should have gender and last name defined";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}

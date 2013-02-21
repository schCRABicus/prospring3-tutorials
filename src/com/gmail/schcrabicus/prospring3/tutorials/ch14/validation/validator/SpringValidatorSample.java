package com.gmail.schcrabicus.prospring3.tutorials.ch14.validation.validator;

import com.gmail.schcrabicus.prospring3.tutorials.ch14.validation.validator.domain.Contact;
import com.gmail.schcrabicus.prospring3.tutorials.ch14.validation.validator.domain.Customer;
import com.gmail.schcrabicus.prospring3.tutorials.ch14.validation.validator.domain.CustomerType;
import com.gmail.schcrabicus.prospring3.tutorials.ch14.validation.validator.service.MyBeanValidationService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import javax.validation.ConstraintViolation;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * User: schcrabicus
 * Date: 20.02.13
 * Time: 7:41
 * To change this template use File | Settings | File Templates.
 */
public class SpringValidatorSample {

    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:**/ch14/validation/validator/config/spring-app-config.xml");

        Contact contact = new Contact();
        contact.setFirstName(null);
        contact.setLastName("Ho");

        Validator contactValidator = ctx.getBean("contactValidator" , Validator.class);

        BeanPropertyBindingResult bindingResult = new BeanPropertyBindingResult( contact , "clarence");

        ValidationUtils.invokeValidator(contactValidator, contact, bindingResult);

        List<ObjectError> errors = bindingResult.getAllErrors();
        System.out.println("No of validation errors: " + errors.size());
        for (ObjectError error: errors) {
            System.out.println(error.getCode());
        }

        System.out.println("------------------------------------");
        System.out.println("------------------------------------");
        MyBeanValidationService myBeanValidationService = ctx.getBean("myBeanValidationService",
                        MyBeanValidationService.class);
        Customer customer = new Customer();
// Test basic constraints
        customer.setFirstName("C");
        customer.setLastName("Ho");
        customer.setCustomerType(null);
        customer.setGender(null);
        validateCustomer(customer, myBeanValidationService);

        // Test custom constraints
        System.out.println("------------------------------------");
        System.out.println("------------------------------------");
        System.out.println("----------Test custom constraints--------");
        customer.setFirstName("Clarence");
        customer.setLastName("Ho");
        customer.setCustomerType(CustomerType.INDIVIDUAL);
        customer.setGender(null);
        validateCustomer(customer, myBeanValidationService);
    }

    private static void validateCustomer(Customer customer,
                                         MyBeanValidationService myBeanValidationService) {
        Set<ConstraintViolation<Customer>> violations =
                new HashSet<ConstraintViolation<Customer>>();
        violations = myBeanValidationService.validateCustomer(customer);
        listViolations(violations);
    }
    private static void listViolations(Set<ConstraintViolation<Customer>> violations) {
        System.out.println("No. of violations: " + violations.size());
        for (ConstraintViolation<Customer> violation: violations) {
            System.out.println("Validation error for property: " +
                    violation.getPropertyPath()
                    + " with value: " + violation.getInvalidValue()
                    + " with error message: " + violation.getMessage());
        }
    }
}

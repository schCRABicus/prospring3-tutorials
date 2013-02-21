package com.gmail.schcrabicus.prospring3.tutorials.ch14.validation.validator.domain;

import com.gmail.schcrabicus.prospring3.tutorials.ch14.validation.validator.validator.custom.CheckIndividualCustomer;

import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Created with IntelliJ IDEA.
 * User: schcrabicus
 * Date: 20.02.13
 * Time: 7:52
 * To change this template use File | Settings | File Templates.
 */
@CheckIndividualCustomer
public class Customer {

    @NotNull(message = "{validation.customer.firstname.NotNull.message}")
    @Size(min = 2, max = 64, message="{validation.customer.firstname.Size.message}")
    private String firstName;

    private String lastName;

    @NotNull(message = "{validation.customer.firstname.NotNull.message}")
    private CustomerType customerType;

    private Gender gender;

    public boolean isIndividualCustomer() {
        return this.customerType.equals(CustomerType.INDIVIDUAL);
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public CustomerType getCustomerType() {
        return customerType;
    }

    public void setCustomerType(CustomerType customerType) {
        this.customerType = customerType;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    // Codes omitted
    @AssertTrue(message="@AssertTrue : Individual customer should have gender and last name defined")
    public boolean isValidIndividualCustomer(){
        boolean result = true;

        if (getCustomerType() != null &&
                (isIndividualCustomer() && (gender == null || lastName == null)))
            result = false;
        return result;
    }
}

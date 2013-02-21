package com.gmail.schcrabicus.prospring3.tutorials.ch14.validation.conversion;

import com.gmail.schcrabicus.prospring3.tutorials.ch14.validation.conversion.domain.Contact;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.convert.ConversionService;

/**
 * Created with IntelliJ IDEA.
 * User: schcrabicus
 * Date: 19.02.13
 * Time: 7:40
 * To change this template use File | Settings | File Templates.
 */
public class PropEditorExaxmple {

    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:**/ch14/validation/conversion/config/spring-app-config.xml");

        Contact clarence = ctx.getBean("clarense", Contact.class);
        System.out.println("Clarence info: " + clarence);
        Contact myContact = ctx.getBean("myContact", Contact.class);
        System.out.println("My contact info: " + myContact);

        ConversionService conversionService = ctx.getBean( "conversionService1", ConversionService.class);
        System.out.println("Birthdate of contact is : " +
                conversionService.convert(clarence.getBirthDate(), String.class));
    }

}

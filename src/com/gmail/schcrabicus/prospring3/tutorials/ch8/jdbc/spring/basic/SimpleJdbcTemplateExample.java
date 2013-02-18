package com.gmail.schcrabicus.prospring3.tutorials.ch8.jdbc.spring.basic;

import com.gmail.schcrabicus.prospring3.tutorials.ch8.jdbc.spring.basic.dao.IContactDao;
import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created with IntelliJ IDEA.
 * User: schcrabicus
 * Date: 25.01.13
 * Time: 8:14
 * To change this template use File | Settings | File Templates.
 */
public class SimpleJdbcTemplateExample {

    private static Logger log = Logger.getLogger(SimpleJdbcTemplateExample.class);

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:**/ch8/jdbc/spring/basic/spring-config.xml");

        IContactDao dao = context.getBean("jdbcContactDao", IContactDao.class);
        log.info(dao.findFirstNameById(1l));

        log.info("Retrieving last name by id : ");
        log.info(dao.findLastNameById(1l));
    }
}

package com.gmail.schcrabicus.prospring3.tutorials.ch4.collection.injection.annotation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * User: schcrabicus
 * Date: 03.01.13
 * Time: 8:40
 * To change this template use File | Settings | File Templates.
 */
@Service
public class CollectionInjection {

    @Resource(name = "map")
    private Map<String, Object> map;

    @Resource(name = "props")
    private Properties props;

    @Resource(name = "set")
    private Set set;

    @Resource(name = "list")
    private List list;

    public static void main(String[] args){
        ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:**/spring-app-config-collection-injection-annotation.xml");

        CollectionInjection collectionInjection = ctx.getBean("collectionInjection", CollectionInjection.class);
        collectionInjection.displayInfo();
    }

    public void displayInfo(){

        System.out.println("Map contents : \n");
        for (Map.Entry<String, Object> entry : map.entrySet()){
            System.out.println("Key : " + entry.getKey() + ";");
            System.out.println("Value : " + entry.getValue() + ";");
        }

        System.out.println("\n" +
                "\nProperties contents : \n");
        for (Map.Entry<Object, Object> entry : props.entrySet()){
            System.out.println("Key : " + entry.getKey() + ";");
            System.out.println("Value : " + entry.getValue() + ";");
        }

        System.out.println("\n" +
                "\nSet contents : \n");
        for (Object value : set){
            System.out.println("Value : " + value + ";");
        }

        System.out.println("\n" +
                "\nList contents : \n");
        for (Object value : list){
            System.out.println("Value : " + value + ";");
        }
    }

    public void setMap(Map<String, Object> map) {
        this.map = map;
    }

    public void setProps(Properties props) {
        this.props = props;
    }

    public void setSet(Set set) {
        this.set = set;
    }

    public void setList(List list) {
        this.list = list;
    }
}

package com.gmail.schcrabicus.prospring3.tutorials.ch5.lifecycle.javaConfiguration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created with IntelliJ IDEA.
 * User: schcrabicus
 * Date: 14.01.13
 * Time: 7:44
 * To change this template use File | Settings | File Templates.
 */
@Configuration
public class AppConfig {

    @Bean
    public MessageProvider messageProvider(){
        return new ConfigurableMessageProvider("configured message");
    }

    @Bean
    public MessageRenderer messageRenderer(){
        MessageRenderer renderer = new StandardOutMessageRenderer();
        renderer.setMessageProvider(messageProvider());

        return renderer;
    }
}

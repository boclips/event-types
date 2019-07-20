package com.boclips.eventbus;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@EnableBoclipsEvents
@SpringBootApplication
class DemoApplication {
    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Bean
    @AutoConfigureOrder(1000)
    public DemoSubscriptionListener demoSubscriptionListener() {
        return new DemoSubscriptionListener();
    }


    @Bean
    public ObjectMapper objectMapper() {
        return new ObjectMapper();
    }
}

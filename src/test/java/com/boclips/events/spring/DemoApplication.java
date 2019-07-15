package com.boclips.events.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.test.binder.TestSupportBinderAutoConfiguration;

@EnableBoclipsEvents(appName = "demo-application")
@SpringBootApplication(exclude = TestSupportBinderAutoConfiguration.class)
class DemoApplication {
    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }
}

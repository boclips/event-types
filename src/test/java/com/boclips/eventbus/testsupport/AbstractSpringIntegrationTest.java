package com.boclips.eventbus.testsupport;

import com.boclips.eventbus.EventBus;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ActiveProfiles("test")
@SpringBootTest(classes = DemoApplication.class)
@ExtendWith(SpringExtension.class)
public class AbstractSpringIntegrationTest {

    @Autowired
    EventBus eventBus;

    @AfterEach
    void tearDown() {
//        eventBus.unsubscribeAll();
    }
}

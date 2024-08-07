package com.freetime.event.example;

import com.freetime.event.example.service.SenderService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class EventExampleApplicationTests {

    @Autowired
    SenderService senderService;
    @Test
    void contextLoads() {
        senderService.send("freetime");
    }

}

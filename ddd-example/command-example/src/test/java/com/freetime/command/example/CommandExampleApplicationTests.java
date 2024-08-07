package com.freetime.command.example;

import com.freetime.command.example.commands.DemoCommand;
import com.freetime.command.example.service.DemoService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CommandExampleApplicationTests {

    @Autowired
    DemoService demoService;
    @Test
    void contextLoads() {
        DemoCommand demoCommand = new DemoCommand();
        demoCommand.setName("test");
        demoService.test(demoCommand);
    }

}

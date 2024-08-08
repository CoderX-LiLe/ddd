package com.freetime.command.example.service;

import com.freetime.ddd.command.base.BaseCommand;
import com.freetime.ddd.command.base.BaseService;
import com.freetime.ddd.command.invoker.CommandInvoker;
import org.springframework.stereotype.Service;


@Service
public class DemoService extends BaseService {

    public DemoService(CommandInvoker commandInvoker) {
        super(commandInvoker);
    }

    public void test(BaseCommand<String> baseCommand) {
        commandInvoker.executeCommand(baseCommand);
        String result = baseCommand.getResult();
        System.out.println(result);
    }
}

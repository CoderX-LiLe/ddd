package com.freetime.ddd.command.invoker;

import com.freetime.ddd.command.base.BaseCommand;
import org.springframework.stereotype.Component;

@Component
public class CommandInvoker {

    public void executeCommand(BaseCommand<?> commandToExecute) {
        commandToExecute.execute();
    }
}

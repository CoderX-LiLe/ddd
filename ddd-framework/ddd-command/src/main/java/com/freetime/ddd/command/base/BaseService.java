package com.freetime.ddd.command.base;

import com.freetime.ddd.command.invoker.CommandInvoker;

public abstract class BaseService {

    protected final CommandInvoker commandInvoker;

    public BaseService(CommandInvoker commandInvoker) {
        this.commandInvoker = commandInvoker;
    }
}

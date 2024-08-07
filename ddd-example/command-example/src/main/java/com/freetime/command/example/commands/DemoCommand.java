package com.freetime.command.example.commands;

import com.freetime.ddd.command.base.BaseCommand;

public class DemoCommand extends BaseCommand<String> {

    private String name;

    @Override
    public void execute() {
        setResult(name);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

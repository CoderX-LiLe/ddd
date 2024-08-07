package com.freetime.ddd.command.base;

public abstract class BaseCommand<T> {
    private T result;

    public abstract void execute();

    protected void setResult(T result) {
        this.result = result;
    }

    public T getResult() {
        return result;
    }
}

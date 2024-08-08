package com.freetime.ddd.command.base;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;

@Getter
public abstract class BaseCommand<T> {

    @JsonIgnore
    private T result;

    public abstract void execute();

    protected void setResult(T result) {
        this.result = result;
    }

}

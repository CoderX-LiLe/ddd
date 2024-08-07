package com.freetime.ddd.core.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class Result implements Serializable {

    private String code;
    private String message;
    private Boolean success;

    public static Result success() {
        Result result = new Result();
        result.setSuccess(true);
        return result;
    }

    public static Result fail(String code, String message) {
        Result result = new Result();
        result.setSuccess(false);
        result.setCode(code);
        result.setMessage(message);
        return result;
    }

    @Override
    public String toString() {
        return "Result{" +
                "code='" + code + '\'' +
                ", message='" + message + '\'' +
                ", success=" + success +
                '}';
    }
}

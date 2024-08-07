package com.freetime.ddd.core.exception;

import com.freetime.ddd.core.enums.PlatformCodeEnum;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class BaseException extends RuntimeException{

    protected String code;

    protected String msg;


    public BaseException() {
    }

    public BaseException(String code, String msg){
        this.code = code;
        this.msg = msg;
    }

    public BaseException(PlatformCodeEnum platformCodeEnum){
        this.code = platformCodeEnum.getCode();
        this.msg = platformCodeEnum.getMsg();
    }

    @Override
    public String toString() {
        return "BaseException{" +
                "code='" + code + '\'' +
                ", msg='" + msg + '\'' +
                '}';
    }
}

package com.freetime.ddd.core.enums;

import lombok.Getter;

@Getter
public enum PlatformCodeEnum {

    /**
     * 成功
     */
    OK("00000", "ok！"),

    /**
     * 系统未知异常
     */
    SYSTEM_ERROR("10001", "系统异常，请联系管理员！"),

    /**
     * 获取结果异常
     */
    RESULT_NULL("10002", "获取结果为空"),

    /**
     * 参数为空
     */
    NO_ARGS("20000", "参数不能为空！"),

    /**
     * 非法参数
     */
    ARGS_ERROR("20001", "非法参数！"),

    /**
     * 没有访问权限
     */
    NO_AUTH("30000", "没有访问权限！"),

    /**
     * 登录失败
     */
    LOGIN_FAILURE("30001", "登录失败"),

    /**
     * 当前用户未登录
     */
    NO_LOGIN("30002", "当前用户未登录");


    private final String code;
    private final String msg;

    PlatformCodeEnum(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

}


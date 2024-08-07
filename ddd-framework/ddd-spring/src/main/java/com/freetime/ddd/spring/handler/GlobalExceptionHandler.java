package com.freetime.ddd.spring.handler;

import cn.hutool.core.util.StrUtil;
import com.freetime.ddd.core.dto.Result;
import com.freetime.ddd.core.enums.PlatformCodeEnum;
import com.freetime.ddd.core.exception.BaseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletResponse;

@RestControllerAdvice
public class GlobalExceptionHandler {

    private final Logger log = LoggerFactory.getLogger(GlobalExceptionHandler.class);
    final HttpServletResponse response;

    public GlobalExceptionHandler(HttpServletResponse response) {
        this.response = response;
    }

    /**
     * 捕获异常
     * @param exception
     * @return
     */
    @ExceptionHandler(Exception.class)
    public Result onBaseExceptionHandler(Exception exception) {
        return handleErrorInfo(PlatformCodeEnum.SYSTEM_ERROR.getCode(), PlatformCodeEnum.SYSTEM_ERROR.getMsg(), exception);
    }

    /**
     * 捕获运行时异常
     * @param exception
     * @return
     */
    @ExceptionHandler(RuntimeException.class)
    public Result onRuntimeExceptionHandler(RuntimeException exception) {
        return handleErrorInfo(PlatformCodeEnum.SYSTEM_ERROR.getCode(), exception.getMessage(), exception);
    }

    /**
     * 捕获自定义异常
     *
     * @param exception
     * @return
     */
    @ExceptionHandler(BaseException.class)
    public Result onBaseExceptionHandler(BaseException exception) {
        return handleErrorInfo(exception.getCode(), exception.getMsg(), exception);
    }

    public Result handleErrorInfo(String code, String message, Exception exception) {
        log.error("系统异常", exception);
        response.setContentType("application/json;charset=UTF-8");
        return Result.fail(code, StrUtil.isBlank(message) ? exception.getMessage() : message);
    }
}

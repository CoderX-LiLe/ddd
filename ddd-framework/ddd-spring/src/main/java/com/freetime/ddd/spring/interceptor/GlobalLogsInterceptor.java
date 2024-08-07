package com.freetime.ddd.spring.interceptor;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.mvc.method.annotation.ExtendedServletRequestDataBinder;

import javax.servlet.http.HttpServletResponseWrapper;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Aspect
@Order(1)
@Component
public class GlobalLogsInterceptor {

    private static final Logger log = LoggerFactory.getLogger(GlobalLogsInterceptor.class);

    private final ObjectMapper objectMapper;

    public GlobalLogsInterceptor(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    @Pointcut(value = "@within(org.springframework.web.bind.annotation.RestController) || @within(org.springframework.stereotype.Controller)")
    public void pointAspect() {
    }

    @Around("pointAspect()")
    public Object afterPointAspect(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        long statTime = System.currentTimeMillis();
        String className = proceedingJoinPoint.getSignature().getName();
        log.info("Method Name: {}", className.substring(className.lastIndexOf(".") + 1));
        String uuid = UUID.randomUUID().toString().replaceAll("-", "");

        methodBefore(proceedingJoinPoint, uuid);
        Object result = proceedingJoinPoint.proceed();
        methodAfterReturing(proceedingJoinPoint, result, uuid);

        long end = System.currentTimeMillis();
        log.info("Response Result: {}", result);
        log.info("Method Execution Time: {} ms", end - statTime);
        return result;
    }

    private void methodBefore(JoinPoint joinPoint, String uuid) throws JsonProcessingException {
        Object[] objs = joinPoint.getArgs();
        String[] argNames = ((MethodSignature) joinPoint.getSignature()).getParameterNames();
        Map<String, Object> paramMap = new HashMap<>((objs.length / 4) + 1);
        for (int i = 0; i < objs.length; i++) {
            if (!(objs[i] instanceof ExtendedServletRequestDataBinder) && !(objs[i] instanceof HttpServletResponseWrapper)) {
                paramMap.put(argNames[i], objs[i]);
            }
        }
        if (!paramMap.isEmpty()) {
            log.info("{}: 方法:{},参数:{}", uuid, joinPoint.getSignature(), objectMapper.writeValueAsString(paramMap));
        }
    }

    private void methodAfterReturing(JoinPoint joinPoint, Object o, String uuid) throws JsonProcessingException {
        if (o != null) {
            log.info("{}:,方法:{},响应内容:{}", uuid, joinPoint.getSignature(), objectMapper.writeValueAsString(o));
        }
    }

}

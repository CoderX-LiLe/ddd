package com.freetime.ddd.spring.utils;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Component
public class BeanUtils implements ApplicationContextAware {

    private static ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        BeanUtils.applicationContext = applicationContext;
        System.out.println("ApplicationContext set successfully.");
    }

    public static <T> T getBean(Class<T> beanClass) {
        if (applicationContext == null) {
            throw new IllegalStateException("ApplicationContext has not been set.");
        }
        return applicationContext.getBean(beanClass);
    }

    public static <T> T getBean(String beanName, Class<T> beanClass) {
        if (applicationContext == null) {
            throw new IllegalStateException("ApplicationContext has not been set.");
        }
        return applicationContext.getBean(beanName, beanClass);
    }

    public static <T> Map<String, T> getBeanMap(Class<T> beanClass) {
        if (applicationContext == null) {
            throw new IllegalStateException("ApplicationContext has not been set.");
        }

        return applicationContext.getBeansOfType(beanClass);
    }

    public static <T> List<T> getBeanList(Class<T> beanClass) {
        if (applicationContext == null) {
            throw new IllegalStateException("ApplicationContext has not been set.");
        }

        return new ArrayList<>(applicationContext.getBeansOfType(beanClass).values());
    }
}

package com.freetime.ddd.spring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebCorsConfiguration {

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**")  // 对所有的路径应用 CORS 规则
                        .allowedOriginPatterns("*") // 允许所有源
                        .allowedMethods("GET", "POST", "PUT", "DELETE", "HEAD", "OPTIONS") // 允许的请求方式
                        .allowCredentials(true) // 允许证书，否则 session 无法使用
                        .allowedHeaders("*") // 允许所有的请求 header
                        .maxAge(3600); // 预检请求的有效期，单位为秒。设置为1小时
            }
        };
    }
}

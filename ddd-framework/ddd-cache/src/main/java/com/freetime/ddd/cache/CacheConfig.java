package com.freetime.ddd.cache;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "config.cache")
@Data
public class CacheConfig {
    private  String selected;
}

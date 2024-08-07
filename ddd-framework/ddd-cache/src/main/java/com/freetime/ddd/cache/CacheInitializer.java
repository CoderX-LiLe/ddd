package com.freetime.ddd.cache;


import com.freetime.ddd.cache.base.Cache;
import org.springframework.stereotype.Component;


import java.util.Map;

@Component
public class CacheInitializer {
    final CacheConfig cacheConfig;
    final Map<String, Cache> cacheMap;

    public CacheInitializer(Map<String, Cache> cacheMap, CacheConfig cacheConfig) {
        this.cacheMap = cacheMap;
        this.cacheConfig = cacheConfig;
    }

    public Cache getCache() {
        String selected = cacheConfig.getSelected();
        return cacheMap.get(selected);
    }
}

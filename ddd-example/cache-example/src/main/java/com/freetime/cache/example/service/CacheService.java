package com.freetime.cache.example.service;

import com.freetime.ddd.cache.CacheInitializer;
import com.freetime.ddd.cache.base.Cache;
import org.springframework.stereotype.Service;

@Service
public class CacheService {
    final CacheInitializer cacheInitializer;

    public CacheService(CacheInitializer cacheInitializer) {
        this.cacheInitializer = cacheInitializer;
    }

    public void redisCache() {
        String key = "cache:example:key:1";
        Cache cache = cacheInitializer.getCache();
        cache.set(key, "测试");
        cache.get(key);
        cache.delete(key);
    }


}

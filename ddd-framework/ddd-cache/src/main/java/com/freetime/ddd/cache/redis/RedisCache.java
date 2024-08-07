package com.freetime.ddd.cache.redis;

import com.freetime.ddd.cache.base.Cache;
import org.redisson.api.RAtomicLong;
import org.redisson.api.RBucket;
import org.redisson.api.RedissonClient;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Component("redis")
public class RedisCache implements Cache {

    final RedissonClient redissonClient;

    public RedisCache(RedissonClient redissonClient) {
        this.redissonClient = redissonClient;
    }

    @Override
    public void set(String key, Object value) {
        RBucket<Object> bucket = redissonClient.getBucket(key);
        bucket.set(value);
    }

    @Override
    public void set(String key, Object value, long expire, TimeUnit timeUnit) {
        RBucket<Object> bucket = redissonClient.getBucket(key);
        bucket.set(value, expire, timeUnit);
    }

    @Override
    public Object get(String key) {
        RBucket<Object> bucket = redissonClient.getBucket(key);
        return bucket.get();
    }

    @Override
    public void setString(String key, String value, long expire, TimeUnit timeUnit) {
        RBucket<Object> bucket = redissonClient.getBucket(key);
        bucket.set(value, expire, timeUnit);
    }

    @Override
    public String getString(String key) {
        RBucket<Object> bucket = redissonClient.getBucket(key);
        if (!bucket.isExists()) {
            return null;
        }
        Object value = bucket.get();
        if (!(value instanceof String)) {
            return null;
        }
        return value.toString();
    }

    @Override
    public void delete(String key) {
        RBucket<Object> bucket = redissonClient.getBucket(key);
        bucket.delete();
    }

    @Override
    public void incr(String key) {
        RAtomicLong atomicLong = redissonClient.getAtomicLong(key);
        atomicLong.incrementAndGet();
    }

    @Override
    public void decr(String key) {
        RAtomicLong atomicLong = redissonClient.getAtomicLong(key);
        atomicLong.decrementAndGet();
    }
}

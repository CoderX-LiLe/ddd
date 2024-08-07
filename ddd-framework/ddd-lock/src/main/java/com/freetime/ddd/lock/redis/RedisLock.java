package com.freetime.ddd.lock.redis;

import com.freetime.ddd.lock.base.Lock;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;

public class RedisLock implements Lock {

    private static final Logger log = LoggerFactory.getLogger(RedisLock.class);

    final RedissonClient redissonClient;

    public  RedisLock(RedissonClient redissonClient) {
        this.redissonClient = redissonClient;
    }

    @Override
    public boolean lock(String key) {
        RLock lock = redissonClient.getLock(key);
        return lock.tryLock();
    }

    @Override
    public boolean lock(String key, long expire, TimeUnit timeUnit) {
        RLock lock = redissonClient.getLock(key);
        try {
            return lock.tryLock(expire, timeUnit);
        } catch (InterruptedException e) {
            log.error(e.getMessage());
        }
        return false;
    }

    @Override
    public void unLock(String key) {
        RLock lock = redissonClient.getLock(key);
        lock.unlock();
    }
}

package com.freetime.lock.example.service;

import com.freetime.ddd.lock.LockInitializer;
import com.freetime.ddd.lock.base.Lock;
import com.freetime.lock.example.constants.RedisKeyConstants;
import org.springframework.stereotype.Service;

@Service
public class LockService {
    final LockInitializer lockInitializer;

    public LockService(LockInitializer lockInitializer) {
        this.lockInitializer = lockInitializer;
    }

    public void redisLock() {
        String key = RedisKeyConstants.getTestKey(1L);
        Lock lock = lockInitializer.getLock();

        boolean locked = lock.lock(key);
        if (locked) {
            System.out.println("Lock success");
        } else {
            System.out.println("Lock failed");
        }
        lock.unLock(key);
    }
}

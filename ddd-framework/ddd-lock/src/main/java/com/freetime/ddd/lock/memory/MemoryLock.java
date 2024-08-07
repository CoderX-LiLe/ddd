package com.freetime.ddd.lock.memory;

import com.freetime.ddd.lock.base.Lock;

import java.util.concurrent.TimeUnit;

public class MemoryLock implements Lock {
    @Override
    public boolean lock(String key) {
        return false;
    }

    @Override
    public boolean lock(String key, long expire, TimeUnit timeUnit) {
        return false;
    }

    @Override
    public void unLock(String key) {

    }
}

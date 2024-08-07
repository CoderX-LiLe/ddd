package com.freetime.ddd.lock.database;

import com.freetime.ddd.lock.base.Lock;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Component("database")
public class DatabaseLock implements Lock {

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

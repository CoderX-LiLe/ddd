package com.freetime.ddd.lock.base;

import java.util.concurrent.TimeUnit;

public interface Lock {

    boolean lock(String key);

    boolean lock(String key, long expire, TimeUnit timeUnit);

    void unLock(String key);
}

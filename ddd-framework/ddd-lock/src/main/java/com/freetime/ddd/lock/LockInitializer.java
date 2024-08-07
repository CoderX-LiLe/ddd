package com.freetime.ddd.lock;

import com.freetime.ddd.lock.base.Lock;
import org.springframework.stereotype.Component;

@Component
public class LockInitializer {
    private final LockConfig lockConfig;

    public LockInitializer(LockConfig lockConfig) {
        this.lockConfig = lockConfig;
    }

    public Lock getLock() {
        return lockConfig.getLock();
    }
}

package com.freetime.ddd.lock;

import com.freetime.ddd.lock.base.Lock;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
@ConfigurationProperties(prefix = "config.lock")
@Data
public class LockConfig {

    private String selected;

    private Map<String, Lock> lockMap;

    public Lock getLock() {
        return lockMap.get(selected);
    }

    public Lock getLock(String key) {
        return lockMap.get(key);
    }

    public void registerLock(String key, Lock lock) {
        lockMap.put(key, lock);
    }
}

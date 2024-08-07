package com.freetime.ddd.redisson.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
@ConfigurationProperties(prefix = "redisson")
@Data
public class RedissonProperties {

    private int timeout = 3000;

    private String address;

    private String password;

    private int connectionPoolSize = 64;

    private int connectionMinimumIdleSize = 10;

    private int slaveConnectionPoolSize = 250;

    private int masterConnectionPoolSize = 250;

    private String[] sentinelAddresses;

    private String masterName;

    @Override
    public String toString() {
        return "RedissonProperties{" +
                "timeout=" + timeout +
                ", address='" + address + '\'' +
                ", password='" + password + '\'' +
                ", connectionPoolSize=" + connectionPoolSize +
                ", connectionMinimumIdleSize=" + connectionMinimumIdleSize +
                ", slaveConnectionPoolSize=" + slaveConnectionPoolSize +
                ", masterConnectionPoolSize=" + masterConnectionPoolSize +
                ", sentinelAddresses=" + Arrays.toString(sentinelAddresses) +
                ", masterName='" + masterName + '\'' +
                '}';
    }
}

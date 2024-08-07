package com.freetime.lock.example.constants;

public class RedisKeyConstants {

    private static final String TEST_KEY = "lock:example:lock:";

    public static String getTestKey(Long id) {
        return TEST_KEY + id;
    }
}

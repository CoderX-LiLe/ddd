package com.freetime.cache.example.constants;


import jdk.nashorn.internal.objects.annotations.Getter;

public class RedisKeyConstants {
    private static final String TEST_KEY = "cache:example:key:";

    public static String getTestKey(Long id) {
        return TEST_KEY + id;
    }
}
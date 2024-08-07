package com.freetime.ddd.cache.base;

import java.util.concurrent.TimeUnit;

public interface Cache {

    /**
     * 添加缓存
     * 此为永久缓存，慎用
     *
     * @param key 缓存key
     * @param value 缓存值
     */
    void set(String key, Object value);

    /**
     * 添加缓存
     *
     * @param key 缓存key
     * @param value 缓存值
     * @param expire 过期时间
     * @param expire 过期时间单位
     */
    void set(String key, Object value, long expire, TimeUnit timeUnit);

    /**
     * 获取缓存
     *
     * @param key 缓存key
     * @return
     */
    Object get(String key);

    /**
     * 添加缓存
     *
     * @param key 缓存key
     * @param value 缓存值
     * @param expire 过期时间
     * @param timeUnit 过期时间单位
     */
    void setString(String key, String value, long expire, TimeUnit timeUnit);

    /**
     * 获取缓存
     *
     * @param key 缓存key
     * @return
     */
    String getString(String key);

    /**
     * 删除
     *
     * @param key 缓存key
     */
    void delete(String key);

    /**
     * 原子性自增
     *
     * @param key 缓存key
     */
    void incr(String key);

    /**
     * 原子性自减
     *
     * @param key 缓存key
     */
    void decr(String key);

}

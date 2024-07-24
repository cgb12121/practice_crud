package com.backend.practice.cache;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Slf4j
@Component
public class CacheStore<K, V> {

    private final Cache<K, V> cache;

    public CacheStore(int expireDuration, TimeUnit timeUnit) {
        cache = CacheBuilder.newBuilder()
                .expireAfterWrite(expireDuration, timeUnit)
                .concurrencyLevel(Runtime.getRuntime().availableProcessors())
                .build();
    }

    public V get(@NonNull K key) {
        log.info("get key: {}", key);
        return cache.getIfPresent(key);
    }

    public void put(@NonNull K key, @NonNull V value) {
        log.info("put key: {}", key);
        cache.put(key, value);
    }

    public void remove(@NonNull K key) {
        log.info("remove key: {}", key);
        cache.invalidate(key);
    }
}

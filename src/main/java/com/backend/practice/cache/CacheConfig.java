package com.backend.practice.cache;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.TimeUnit;

@Configuration
public class CacheConfig {

    @Bean
    public CacheStore<String, Integer> cacheStore(int expireDuration, TimeUnit timeUnit) {
        return new CacheStore<>(expireDuration, timeUnit);
    }

    @Bean
    public int expireDuration() {
        return 10;
    }

    @Bean
    public TimeUnit timeUnit() {
        return TimeUnit.MINUTES;
    }
}

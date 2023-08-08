package com.cache.config;
import lombok.*;
import org.springframework.boot.context.properties.*;
import org.springframework.context.annotation.*;
@Configuration
@ConfigurationProperties(prefix = "cache")
@Data
public class CacheConfig {
    private String evictionPolicy = "LRU";
    private int maxSize = 10000;
    private boolean replicationEnabled = false;
}

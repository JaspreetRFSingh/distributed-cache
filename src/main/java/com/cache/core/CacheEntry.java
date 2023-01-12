package com.cache.core;
import lombok.*;
import java.time.*;
@Data
@Builder
public class CacheEntry {
    private String key;
    private String value;
    private LocalDateTime createdAt;
    private LocalDateTime expiresAt;
    private long ttl;
    private int version;
    public boolean isExpired() {
        return expiresAt != null && LocalDateTime.now().isAfter(expiresAt);
    }
}

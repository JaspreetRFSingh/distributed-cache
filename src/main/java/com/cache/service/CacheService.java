package com.cache.service;
import com.cache.core.CacheEntry;
import com.cache.core.CacheStore;
import com.cache.eviction.EvictionManager;
import com.cache.replication.ReplicationManager;
import lombok.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.*;
import java.time.LocalDateTime;
@Service
@RequiredArgsConstructor
@Slf4j
public class CacheService {
    private final CacheStore cacheStore;
    private final EvictionManager evictionManager;
    private final ReplicationManager replicationManager;
    public void put(String key, String value, long ttlSeconds) {
        CacheEntry entry = CacheEntry.builder()
                .key(key).value(value)
                .createdAt(LocalDateTime.now())
                .expiresAt(LocalDateTime.now().plusSeconds(ttlSeconds))
                .ttl(ttlSeconds).version(1).build();
        cacheStore.put(key, entry);
        replicationManager.replicate(key, entry);
        log.info("Cached key: {} with TTL: {}s", key, ttlSeconds);
    }
    public String get(String key) {
        CacheEntry entry = cacheStore.get(key);
        if (entry == null || entry.isExpired()) {
            return null;
        }
        return entry.getValue();
    }
    public void delete(String key) { cacheStore.remove(key); }
}

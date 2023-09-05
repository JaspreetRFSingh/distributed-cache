package com.cache.service;
import com.cache.core.CacheEntry;
import com.cache.core.CacheStore;
import lombok.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.*;
import java.util.*;
@Service
@RequiredArgsConstructor
@Slf4j
public class BatchCacheService {
    private final CacheStore cacheStore;
    public void putAll(Map<String, String> entries, long ttl) {
        log.info("Batch inserting {} entries", entries.size());
        entries.forEach((k, v) -> cacheStore.put(k, CacheEntry.builder().key(k).value(v).build()));
    }
    public Map<String, String> getAll(Collection<String> keys) {
        Map<String, String> result = new HashMap<>();
        keys.forEach(k -> { CacheEntry e = cacheStore.get(k); if (e != null) result.put(k, e.getValue()); });
        return result;
    }
}

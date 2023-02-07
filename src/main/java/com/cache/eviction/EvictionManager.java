package com.cache.eviction;
import com.cache.core.CacheEntry;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.*;
import java.util.*;
import java.util.concurrent.*;
@Component
@Slf4j
public class EvictionManager {
    private EvictionPolicy policy = EvictionPolicy.LRU;
    private final LinkedHashMap<String, CacheEntry> lruCache = new LinkedHashMap<>(16, 0.75f, true) {
        @Override
        protected boolean removeEldestEntry(Map.Entry<String, CacheEntry> eldest) {
            return size() > 1000;
        }
    };
    public void evict(Map<String, CacheEntry> cache) {
        log.info("Evicting entries using {} policy", policy);
    }
}

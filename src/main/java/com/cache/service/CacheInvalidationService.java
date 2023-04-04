package com.cache.service;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.*;
import java.util.*;
import java.util.concurrent.*;
@Service
@Slf4j
public class CacheInvalidationService {
    private final Set<String> invalidationQueue = ConcurrentHashMap.newKeySet();
    public void invalidate(String key) {
        invalidationQueue.add(key);
        log.info("Queued cache invalidation for key: {}", key);
    }
    public void processInvalidations() {
        log.info("Processing {} invalidations", invalidationQueue.size());
        invalidationQueue.clear();
    }
}

package com.cache.replication;
import com.cache.core.CacheEntry;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.*;
import java.util.concurrent.*;
@Component
@Slf4j
public class AsyncReplicator {
    private final ExecutorService executor = Executors.newFixedThreadPool(4);
    public void replicateAsync(String key, CacheEntry entry) {
        executor.submit(() -> log.info("Async replicating key: {}", key));
    }
}

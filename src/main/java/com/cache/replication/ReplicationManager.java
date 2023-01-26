package com.cache.replication;
import com.cache.core.CacheEntry;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.*;
import java.util.*;
import java.util.concurrent.*;
@Component
@Slf4j
public class ReplicationManager {
    private final List<String> replicas = new CopyOnWriteArrayList<>();
    public void addReplica(String replicaUrl) { replicas.add(replicaUrl); }
    public void replicate(String key, CacheEntry entry) {
        log.info("Replicating key {} to {} replicas", key, replicas.size());
    }
    public List<String> getReplicas() { return replicas; }
}

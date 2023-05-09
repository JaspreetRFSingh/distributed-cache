package com.cache.eviction;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.*;
import java.util.*;
import java.util.concurrent.*;
@Component
@Slf4j
public class LFUEviction {
    private final Map<String, Integer> frequencyMap = new ConcurrentHashMap<>();
    public void recordAccess(String key) { frequencyMap.merge(key, 1, Integer::sum); }
    public String getLeastFrequent() {
        return frequencyMap.entrySet().stream().min(Map.Entry.comparingByValue()).map(Map.Entry::getKey).orElse(null);
    }
}

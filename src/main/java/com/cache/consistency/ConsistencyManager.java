package com.cache.consistency;
import com.cache.core.CacheEntry;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.*;
import java.util.*;
import java.util.concurrent.*;
@Component
@Slf4j
public class ConsistencyManager {
    private ConsistencyLevel level = ConsistencyLevel.STRONG;
    public void setConsistencyLevel(ConsistencyLevel level) { this.level = level; }
    public CacheEntry resolveConflict(List<CacheEntry> versions) {
        if (level == ConsistencyLevel.STRONG) {
            return versions.get(0);
        }
        return versions.stream().max(Comparator.comparing(CacheEntry::getVersion)).orElse(null);
    }
}

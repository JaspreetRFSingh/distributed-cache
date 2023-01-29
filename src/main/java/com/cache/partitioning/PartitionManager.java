package com.cache.partitioning;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.*;
import java.util.*;
import java.util.concurrent.*;
@Component
@Slf4j
public class PartitionManager {
    private final int numPartitions = 16;
    public int getPartition(String key) {
        return Math.abs(key.hashCode()) % numPartitions;
    }
    public String getPartitionKey(String key) {
        return "partition:" + getPartition(key);
    }
}

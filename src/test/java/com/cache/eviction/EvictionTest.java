package com.cache.eviction;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
class EvictionTest {
    @Test void testLFU() {
        LFUEviction lfu = new LFUEviction();
        lfu.recordAccess("key1");
        lfu.recordAccess("key1");
        lfu.recordAccess("key2");
        assertEquals("key2", lfu.getLeastFrequent());
    }
}

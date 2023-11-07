package com.cache.util;
public class CacheKeyBuilder {
    public static String build(String... parts) {
        return String.join(":", parts);
    }
}

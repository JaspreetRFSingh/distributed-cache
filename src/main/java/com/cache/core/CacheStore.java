package com.cache.core;
import java.util.*;
import java.util.concurrent.*;
public class CacheStore {
    private final ConcurrentHashMap<String, CacheEntry> store = new ConcurrentHashMap<>();
    public void put(String key, CacheEntry entry) { store.put(key, entry); }
    public CacheEntry get(String key) { return store.get(key); }
    public void remove(String key) { store.remove(key); }
    public boolean containsKey(String key) { return store.containsKey(key); }
    public int size() { return store.size(); }
}

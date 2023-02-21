package com.cache.controller;
import com.cache.service.CacheService;
import lombok.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("/api/v1/cache")
@RequiredArgsConstructor
public class CacheController {
    private final CacheService cacheService;
    @PutMapping("/{key}")
    public ResponseEntity<Void> put(@PathVariable String key, @RequestParam String value, @RequestParam(defaultValue = "3600") long ttl) {
        cacheService.put(key, value, ttl);
        return ResponseEntity.ok().build();
    }
    @GetMapping("/{key}")
    public ResponseEntity<String> get(@PathVariable String key) {
        String value = cacheService.get(key);
        return value != null ? ResponseEntity.ok(value) : ResponseEntity.notFound().build();
    }
    @DeleteMapping("/{key}")
    public ResponseEntity<Void> delete(@PathVariable String key) {
        cacheService.delete(key);
        return ResponseEntity.noContent().build();
    }
}

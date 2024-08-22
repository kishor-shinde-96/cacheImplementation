package com.cacheImplementation;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cache")
public class CacheController {

    private final CacheService cacheService;

    public CacheController(CacheService cacheService) {
        this.cacheService = cacheService;
    }

    @GetMapping("/get")
    public Item getItemFromCache(@RequestParam String key) {
        return cacheService.getItem(key);
    }

    @PostMapping("/put")
    public Item putItemInCache(@RequestBody Item item) {
        return cacheService.putItemInCache(item);
    }

    @DeleteMapping("/clear")
    public String clearCache() {
        cacheService.clearCache();
        return "Cache cleared successfully!";
    }
}

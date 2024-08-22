package com.cacheImplementation;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.CacheEvict;

@Service
public class CacheService {

    @Cacheable("items")
    public Item getItem(String key) {
        // Simulate a time-consuming operation
        try {
            Thread.sleep(2000); // 2 seconds
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return new Item(key, "ItemName-" + key, "Description for item " + key);
    }

    @CachePut(value = "items", key = "#item.id")
    public Item putItemInCache(Item item) {
        return item;
    }

    @CacheEvict(value = "items", allEntries = true)
    public void clearCache() {
        System.out.println("Clearing all entries from the 'items' cache.");
    }


}


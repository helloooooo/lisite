package com.bruce.guava_learning.cachedemo;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;

import java.sql.Time;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created by wuteng1 on 2016/9/8.
 */
public abstract class LRUCache<K, V> {
    private long cacheSize = 10000;
    private int cacheUpdateInterval = 5;
    private LoadingCache<K, V> loadingCache;

    abstract V hardload(K k);

    public LRUCache(long cacheSize, int cacheUpdateInterval){
        this.cacheSize = cacheSize;
        this.cacheUpdateInterval = cacheUpdateInterval;
        loadingCache = CacheBuilder.newBuilder().expireAfterAccess(cacheUpdateInterval, TimeUnit.SECONDS).maximumSize(cacheSize).build(
                new CacheLoader<K, V>() {
                    @Override
                    public V load(K k) throws Exception {
                        System.out.println("hardload");
                        return hardload(k);
                    }
                }
        );
//        Executors.newScheduledThreadPool(1).scheduleAtFixedRate(new Runnable() {
//            public void run() {
//                for(K key: loadingCache.asMap().keySet()){
//                    V value = hardload(key);
//                    if(value != null){
//                        System.out.println("update value " + value);
//                        loadingCache.put(key, value);
//                    }
//
//                }
//            }
//        }, 0, cacheUpdateInterval, TimeUnit.SECONDS);
    }

    final public V get(K key) throws ExecutionException {
        return loadingCache.get(key);
    }
}

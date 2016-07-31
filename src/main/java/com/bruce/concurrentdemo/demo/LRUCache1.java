package com.bruce.concurrentdemo.demo;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by wuteng1 on 2016/7/22.
 */
public class LRUCache1<K,V> extends LinkedHashMap<K,V> {
    private final int MAX_CACHE_SIZE;
    private ReentrantLock lock = new ReentrantLock();
    public LRUCache1(int cacheSize){
        super((int)Math.ceil(cacheSize/0.75), 0.75f, true);
        MAX_CACHE_SIZE = cacheSize;
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {

        return size() > MAX_CACHE_SIZE;
    }

    @Override
    public V get(Object key) {
        lock.lock();
        try{
            return super.get(key);
        }finally {
            lock.unlock();
        }

    }

    @Override
    public V put(K key, V value) {
        lock.lock();
        try{
            return super.put(key, value);
        }finally {
            lock.unlock();
        }
    }

}

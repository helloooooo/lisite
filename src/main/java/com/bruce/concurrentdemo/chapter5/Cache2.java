package com.bruce.concurrentdemo.chapter5;

import org.apache.commons.collections.map.HashedMap;

import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Created by wuteng1 on 2016/8/14.
 */
public class Cache2 {
    static Map<String, Object> map = new HashedMap();
    static ReentrantReadWriteLock rwl = new ReentrantReadWriteLock();
    static Lock r = rwl.readLock();
    static Lock w = rwl.writeLock();

    public static final Object get(String key){
        r.lock();
        try{
            return map.get(key);
        }finally {
            r.unlock();
        }

    }

    public static final void put(String key, Object value){
        w.lock();
        try{
            map.put(key, value);
        }finally {
            w.unlock();
        }
    }

    public static final void clear(){
        w.lock();
        try{
            map.clear();
        }finally {
            w.unlock();
        }
    }
}

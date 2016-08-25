package com.bruce.concurrentdemo.chapter5;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Created by wuteng1 on 2016/8/11.
 */
public class Cache {
    static Map<String ,Object> map = new HashMap<String, Object>();
    static ReentrantReadWriteLock reentrantLock = new ReentrantReadWriteLock();
    static Lock r  = reentrantLock.readLock();
    static Lock w = reentrantLock.writeLock();

    public static final Object get(String key){
        r.lock();
        try{
            return map.get(key);
        }finally {
            r.unlock();
        }
    }

    public static final Object put(String key, Object object){
        w.lock();
        try{
            return map.put(key, object);
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

package com.bruce.guava_learning.cachedemo;

import java.util.Random;

/**
 * Created by wuteng1 on 2016/9/8.
 */
public class ConcreateLRUCache extends LRUCache<Long, String> {


    public ConcreateLRUCache(long cacheSize, int cacheUpdateInterval) {
        super(cacheSize, cacheUpdateInterval);
    }

    protected String hardload(Long did) {
        return did + ": hello " + System.currentTimeMillis();
    }
}

package com.bruce.guava_learning.cachedemo;

/**
 * Created by wuteng1 on 2016/9/8.
 */
public class ConcreateLRUCache2 extends LRUCache<Long, String> {


    public ConcreateLRUCache2(long cacheSize, int cacheUpdateInterval) {
        super(cacheSize, cacheUpdateInterval);
    }

    String hardload(Long did) {
        return did + ": world";
    }
}

package com.bruce.guava_learning.cachedemo;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import org.junit.Test;

import java.util.Map;
import java.util.concurrent.ExecutionException;

/**
 * Created by wuteng1 on 2016/10/13.
 */
public class HotColdDemo {
    LoadingCache<Integer, Integer> cache = CacheBuilder.newBuilder().maximumSize(3).build(
            new CacheLoader<Integer, Integer>() {
                @Override
                public Integer load(Integer key) throws Exception {
                    System.out.println("hard load for " + key);
                    return key;
                }
            }
    );

    @Test
    public void testCold2Hot() throws ExecutionException {
        cache.get(2);
        cache.get(1);
        cache.get(3);
        cache.get(2);
        for(Map.Entry<Integer, Integer> entry: cache.asMap().entrySet()){
            Integer key = entry.getKey();
            Integer value = entry.getValue();
            System.out.println("key = " + key);
            System.out.println("value = " + value);
        }
    }
}

package com.bruce.guava_learning.cachedemo;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/**
 * Created by wuteng1 on 2016/9/8.
 */
public class LRUCacheTest {
    public static void main(String[] args) {
        LRUCache<Long, String> cache = new ConcreateLRUCache(10, 0);
        Map<Long, String> map = new ConcurrentHashMap<Long, String>();
        LRUCache cache2 = new ConcreateLRUCache2(3, 2);
        try {
//            long time1 = System.currentTimeMillis();
//            for(long l = 1; l < 10000; l++)
//                cache.get(l);
//            for(long l = 1; l < 10000; l++)
//                cache.get(l);
//            long time2 = System.currentTimeMillis();
//            System.out.println("time1: " + (time2 - time1));
//            for(long l = 1; l < 10000; l++){
//                map.put(l, String.valueOf(l) + " ...");
//            }
//            for(long l = 1; l < 10000; l++){
//                map.get(l);
//            }for(long l = 1; l < 10000; l++){
//                map.get(l);
//            }
//            long time3 = System.currentTimeMillis();
//            System.out.println("time2: " + (time3 - time2));

            System.out.println(cache.get(1l));
            System.out.println(cache.get(2l));
            System.out.println(cache.get(3l));
            System.out.println("***********");
            System.out.println(cache.get(1l));
            System.out.println(cache.get(2l));
            System.out.println(cache.get(3l));
            System.out.println("***********");
            System.out.println(cache.get(1l));
            System.out.println(cache.get(2l));
            System.out.println(cache.get(3l));

//            System.out.println(cache2.get(1l));
//            System.out.println(cache2.get(2l));
//            System.out.println(cache2.get(3l));
//            System.out.println(cache2.get(4l));
            TimeUnit.SECONDS.sleep(10);
            System.out.println("***************");
            System.out.println(cache.get(1l));
            System.out.println(cache.get(2l));
            System.out.println(cache.get(3l));
            System.out.println(Thread.currentThread().getName());


        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (Exception e){
            System.out.println("cache exception");
            e.printStackTrace();
        }

    }
}

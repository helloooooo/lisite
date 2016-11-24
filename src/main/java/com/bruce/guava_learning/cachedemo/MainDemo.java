package com.bruce.guava_learning.cachedemo;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import org.junit.Test;

import java.sql.Time;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

import static java.lang.Thread.sleep;

/**
 * Created by wuteng1 on 2016/9/22.
 */
public class MainDemo {

    LoadingCache<Long, Long> loadingCache = CacheBuilder.newBuilder().expireAfterAccess(10, TimeUnit.SECONDS).maximumSize(10).build(
                new CacheLoader<Long, Long>() {
        @Override
        public Long load(Long k) throws Exception {
            blockingQueue.offer(k);
            System.out.println("hardload threadName: " + Thread.currentThread().getName());
            TimeUnit.SECONDS.sleep(10);
            return 1l;
        }
        }
    );
    BlockingQueue<Long> blockingQueue = new ArrayBlockingQueue<Long>(100);

    @Test
    public void testLoad() throws InterruptedException {

        for(int i = 0; i < 10; i++){
            new Thread(new Runnable() {

                public void run() {
                    if(null == loadingCache.getIfPresent(1)){
                        if(!blockingQueue.contains(1l))
                            blockingQueue.offer(1l);
                    }
                    else{

                    }


                }
            }).start();
        }

        TimeUnit.SECONDS.sleep(10);
    }
}

package com.bruce.demo.guava;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;

/**
 * Created by wuteng1 on 2016/7/7.
 */
public class TestLoadingCache {
    public static void main(String[] args) throws ExecutionException {
        Cache<String, String> cache = CacheBuilder.newBuilder().maximumSize(1000).build();
        String resultVal = cache.get("jerry", new Callable<String>() {
            public String call() throws Exception {
                String strProValue = "hello + jerry ";
                return strProValue;
            }
        });
        System.out.println("-----------");
        System.out.println(resultVal);
    }
}

package com.bruce.demo.guava;

import com.google.common.collect.HashMultiset;
import com.google.common.collect.ImmutableSet;

import java.util.Arrays;

/**
 * Created by wuteng1 on 2016/7/7.
 */
public class CollectionDemo {
    public static void main(String[] args) {
        ImmutableSet<String> immutableSet = ImmutableSet.of("RED", "GREEN");
        HashMultiset<String> multiset = HashMultiset.create();
        String[] wordList = new String[]{"1","2","1"};
        multiset.addAll(Arrays.asList(wordList));
        System.out.println(multiset.count("1"));

    }
}

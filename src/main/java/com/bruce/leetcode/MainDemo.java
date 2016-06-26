package com.bruce.leetcode;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by wuteng1 on 2016/5/19.
 */
public class MainDemo {
    public static void main(String[] args) {
        Map<String, String> map = new ConcurrentHashMap<String, String>();
        map.put("a", "aVal");
        map.put("b", "bVal");
        Iterator<Map.Entry<String, String>> iter = map.entrySet().iterator();
        while (iter.hasNext()){
            Map.Entry<String, String> entry = iter.next();
            String key = entry.getKey();
            if(key == "a"){
                iter.remove();
            }
        }
        System.out.println(map.get("a"));
        System.out.println(map.get("b"));
    }
}

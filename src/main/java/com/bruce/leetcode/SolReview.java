package com.bruce.leetcode;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by wuteng1 on 2016/10/20.
 */
public class SolReview {

    @Test
    public void test(){
        System.out.println(isAnagram("a", "b"));
    }
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()){
            return false;
        }

        int[] m= new int[26];
        for(int i = 0; i < s.length(); i++){
            m[s.charAt(i) - 'a']++;
        }
        for(int i = 0; i < t.length(); i++){
            if(m[s.charAt(i) - 'a']-- < 0){
                return false;
            }
        }
        return true;
    }
}

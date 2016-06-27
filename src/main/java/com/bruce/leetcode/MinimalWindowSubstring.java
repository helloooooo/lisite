package com.bruce.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by 腾 on 2016/6/20.
 */
public class MinimalWindowSubstring {
    class Solution{
        public String minWindow(String s, String t){
            //get the count of each character
            Map<Character, Integer> map = new HashMap<Character, Integer>();
            for(int i = 0; i < t.length(); i++){
                if(map.containsKey(t.charAt(i))){
                    map.put(t.charAt(i), map.get(t.charAt(i)) + 1);
                }
                else{
                    map.put(t.charAt(i), 1);
                }
            }

            int left=0, cnt=0, start = 0;
            int minLen = s.length() + 1;
            for(int right=0; right < s.length(); right++){
                if(map.containsKey(s.charAt(right))){
                    map.put(s.charAt(right), map.get(s.charAt(right)) - 1);
                    if(map.get(s.charAt(right)) >= 0){
                        cnt++;
                    }
                    //get a valid solution
                    while(cnt == t.length()){
                        if(right - left + 1 < minLen){
                            minLen = right - left + 1;
                            start = left;
                        }
                        if(map.containsKey(s.charAt(left))){
                            map.put(s.charAt(left), map.get(s.charAt(left)) + 1);
                            if(map.get(s.charAt(left)) > 0)
                                cnt--;
                        }
                        left += 1;
                    }
                }

            }
            if(minLen > s.length())
                return "";
            else return s.substring(start, start + minLen);
        }
    }
}

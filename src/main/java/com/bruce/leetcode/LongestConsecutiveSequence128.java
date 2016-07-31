package com.bruce.leetcode;

import java.util.HashSet;

/**
 * Created by wuteng1 on 2016/6/28.
 */
public class LongestConsecutiveSequence128 {
    public static void main(String[] args) {
        Solution sol = new Solution();
        int cnt = sol.longestConsecutive(new int[]{100,4,200,1,3,2});
        System.out.println(cnt);
    }
    static class Solution{
        public int longestConsecutive(int[] nums){
            HashSet<Integer> set = new HashSet<Integer>();
            for(int num: nums)
                set.add(num);
            int max = 0;
            for(int num: nums){
                set.remove(num);
                int cnt = 1;
                int temp = num-1;
                while(set.contains(temp)){
                    set.remove(temp);
                    temp -= 1;
                    cnt += 1;
                }
                temp = num + 1;
                while(set.contains(temp)){
                    set.remove(temp);
                    temp += 1;
                    cnt += 1;
                }
                max = Math.max(cnt, max);
            }
            return max;
        }
    }
}

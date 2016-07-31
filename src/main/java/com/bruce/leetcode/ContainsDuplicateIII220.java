package com.bruce.leetcode;

import java.util.TreeSet;

/**
 * Created by wuteng1 on 2016/6/29.
 */
public class ContainsDuplicateIII220 {
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] nums = new int[]{-1, 2147483647};
        System.out.println(Integer.MAX_VALUE);
        System.out.println(sol.containsNearbyAlmostDuplicate(nums, 1, 2147483647));
    }
    static class Solution{

        public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t){
            if(k < 1 || t < 0 || nums == null || nums.length < 2)
                return false;
            TreeSet<Integer> ts = new TreeSet<Integer>();
            //if the closet num is the most possible value
            //maintain a k-size window
            for(int i = 0; i < nums.length; ++i){
                int num = nums[i];
                //think about integer overflow
                if(ts.floor(num) != null && num - t  <= ts.floor(num) ||
                        ts.ceiling(num) != null && ts.ceiling(num) <= t + num)
                    return true;
                ts.add(num);
                if(i >= k)
                    ts.remove(nums[i-k]);
            }
            return false;
        }
    }
}

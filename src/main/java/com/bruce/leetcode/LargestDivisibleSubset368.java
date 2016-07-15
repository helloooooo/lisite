package com.bruce.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by 腾 on 2016/7/4.
 */
public class LargestDivisibleSubset368 {
    public static void main(String[] args) {
        Solution sol = new Solution();
        List<Integer> tes = sol.largestDivisibleSubset(new int[]{1,2,4,8});
        System.out.println(tes);
    }
    static class Solution{
        public List<Integer> largestDivisibleSubset(int[] nums){
            List<Integer> res = new ArrayList<Integer>();
            if(nums.length == 0)
                return res;
            Arrays.sort(nums);
            int[] dp = new int[nums.length];
            int[] index = new int[nums.length];
            int maxVal = 0, maxIndex = -1;
            Arrays.fill(dp, 1);
            Arrays.fill(index, -1);
            for(int i = 0; i < nums.length; i++){
                for(int j = i-1; j >= 0; j--){
                    if(nums[i] % nums[j] == 0 && dp[i] < dp[j]+1){
                        dp[i] = dp[j] + 1;
                        index[i] = j;
                    }
                }
                if(maxVal < dp[i]){
                    maxVal = dp[i];
                    maxIndex = i;
                }
            }
            for(int i = maxIndex; i != -1; i = index[i]){
                res.add(nums[i]);
            }
            return res;
        }
    }
}

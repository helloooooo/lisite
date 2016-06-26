package com.bruce.leetcode;

/**
 * Created by wuteng1 on 2016/5/31.
 */
public class CountingBits338 {
    class Solution{
        public int[] countBits(int num){
            // *0 -> *1   *01 -> *10   *11 ->
            //dp[i] = dp[i/2] if i & 1 == 0 or dp[i/2]+1
            int[] res = new int[num+1];
            for(int i = 0; i <= num; i++){
                if((i & 1) == 0)
                    res[i] = res[i/2];
                else res[i] = res[i/2] + 1;
            }
            return res;
        }
    }
}

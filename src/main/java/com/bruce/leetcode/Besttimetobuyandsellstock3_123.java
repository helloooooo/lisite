package com.bruce.leetcode;

import java.util.Arrays;

/**
 * Created by wuteng1 on 2016/6/25.
 */
public class Besttimetobuyandsellstock3_123 {
    static Solution s = new Solution();

    public static void main(String[] args) {
        int ret = s.maxProfit(new int[]{2,1,2,0,1});
        System.out.println(ret);
    }
    static class Solution{
        public int maxProfit(int[] prices){
            int len = prices.length;
            if(len < 2)
                return 0;
            //the maximal profit until i
            int[] m = new int[len];
            //the maximal profit after i
            int[] n = new int[len];
            int minM = prices[0];
            for(int i = 1; i < len; i++){
                if(prices[i] < minM)
                    minM = prices[i];
                m[i] = Math.max(m[i-1], prices[i] - minM);
            }
            int maxN = prices[len-1];
            for(int j = len-2; j > 1; j--){
                if(prices[j] > maxN){
                    maxN = prices[j];
                }
                n[j] = Math.max(n[j+1], maxN - prices[j]);
            }
            int ret = 0;
            for(int i = 0; i < len; i++){
                ret = Math.max(m[i] + n[i], ret);
            }
            return ret;
        }
    }
}

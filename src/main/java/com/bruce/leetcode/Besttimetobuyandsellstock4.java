package com.bruce.leetcode;

/**
 * Created by 腾 on 2016/6/24.
 */
public class Besttimetobuyandsellstock4 {
    class Solution{
        public int maxProfit(int k, int[] prices){
            int len = prices.length;
            if(len <= 1)
                return 0;
            int[] l = new int[len];
            int[] g = new int[len];
            if(k > len){
                return getMax(prices);
            }
            for(int i = 0; i < prices.length-1; i++){
                int diff = prices[i+1] - prices[i];
                for(int j = k; j >= 1; j--){
                    l[j] = Math.max(g[j-1] + Math.max(0, diff), l[j] + diff);
                    g[j] = Math.max(g[j], l[j]);
                }
            }
            return g[k];
        }

        public int getMax(int[] prices){
            int ret = 0;
            for(int i = 0; i<prices.length-1; i++){
                if(prices[i+1] - prices[i] > 0){
                    ret += prices[i+1] - prices[i];
                }
            }
            return ret;
        }
    }
}

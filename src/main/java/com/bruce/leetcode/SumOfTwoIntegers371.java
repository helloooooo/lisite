package com.bruce.leetcode;

/**
 * Created by 腾 on 2016/7/4.
 */
public class SumOfTwoIntegers371 {
    public static void main(String[] args) {
        Solution sol = new Solution();
        int c = sol.getSum(3,2);
        System.out.println(c);

    }
    static class Solution{
        public int getSum(int a,int b){
            while(b != 0){
                int c = a & b;
                a ^= b;
                b = c << 1;
            }
            return a;
        }
    }
}

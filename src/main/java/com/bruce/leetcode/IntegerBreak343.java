package com.bruce.leetcode;

/**
 * Created by wuteng1 on 2016/7/3.
 */
public class IntegerBreak343 {
    static class Solution{
        public int integerBreak(int n){
            if(n == 3 || n == 2)
                return n-1;
            int res = 1;
            while(n > 4){
                n -= 3;
                res *= 3;
            }
            return res*n;
        }
    }
}

package com.bruce.leetcode;

/**
 * Created by wuteng1 on 2016/6/28.
 */
public class ValidPerfectSquare367 {
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.isPerfectSquare(2147483647));
    }
    static class Solution{
        public boolean isPerfectSquare(int num){
            long start = 1, end = (num >> 1) + 1;
            while(start <= end){
                long mid = (start + end) >> 1;
                if(mid * mid < num){
                    start = mid + 1;
                }
                else if(mid * mid > num){
                    end = mid - 1;
                }
                else return true;
            }
            return false;
        }
    }
}

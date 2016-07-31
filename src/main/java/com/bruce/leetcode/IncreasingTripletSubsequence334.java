package com.bruce.leetcode;

/**
 * Created by wuteng1 on 2016/6/28.
 */
public class IncreasingTripletSubsequence334 {
    static class Solution{
        public boolean increasingTriplet(int[] nums){
            //m1 is the minimal value, m2 is the second minimal value
            //5 4 6 3
            int m1 = Integer.MAX_VALUE, m2 = Integer.MAX_VALUE;
            for(int num: nums){
                if(num <= m1)
                    m1 = num;
                else if(num <= m2)
                    m2 = num;
                else return true;
            }
            return false;
        }
    }
}

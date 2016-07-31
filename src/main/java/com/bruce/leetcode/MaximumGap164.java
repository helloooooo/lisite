package com.bruce.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by 腾 on 2016/6/21.
 */
public class MaximumGap164 {
    class Solution{
        public int maximumGap(int[] nums){
            if(nums.length < 2)
                return 0;
            int maxVal = nums[0], minVal = nums[0];
            for(int i = 1; i < nums.length; i++){
                maxVal = Math.max(maxVal, nums[i]);
                minVal = Math.min(minVal, nums[i]);
            }
            int len = (maxVal - minVal) / nums.length + 1;
            int cnt = (maxVal - minVal) / len + 1;
            int[] minArray = new int[cnt];
            int[] maxArray = new int[cnt];
            for(int i = 0; i < cnt; i++){
                minArray[i] = Integer.MAX_VALUE;
                maxArray[i] = Integer.MIN_VALUE;
            }
            for(int i = 0; i < nums.length; i++){
                if(nums[i] > maxArray[(nums[i]-minVal)/len]){
                    maxArray[(nums[i]-minVal)/len] = nums[i];
                }
                if(nums[i] < minArray[(nums[i]-minVal)/len]){
                    minArray[(nums[i]-minVal)/len] = nums[i];
                }
            }
            int largest = 0, maxV = maxArray[0];
            for(int i = 1; i < cnt-1; i++){
                if(minArray[i] != Integer.MAX_VALUE){
                    largest = Math.max(largest, minArray[i] - maxV);
                    maxV = maxArray[i];
                }
            }
            return Math.max(largest, maxVal - maxV);
        }
    }
}

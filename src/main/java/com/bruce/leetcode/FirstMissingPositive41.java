package com.bruce.leetcode;

/**
 * Created by wuteng1 on 2016/7/7.
 */
public class FirstMissingPositive41 {
    public static void main(String[] args) {

    }
    static class Solution{
        public int firstMissingPositive(int[] nums){
            //store number i in the i-1 position
            int n = nums.length, i = 0;
            while(i < n){
                if(nums[i] != i+1 && nums[i] <= n && nums[i] >= 1 && nums[i] != nums[nums[i]-1]){
                    //store nums[i] in the nums[i]-1 position
                    int temp = nums[i];
                    nums[i] = nums[nums[i]-1];
                    nums[nums[i]-1] = temp;
                }
                else i++;
            }
            for(i = 0; i < n; i++){
                if(nums[i] != i+1)
                    return i+1;
            }
            return n+1;
        }
    }
}

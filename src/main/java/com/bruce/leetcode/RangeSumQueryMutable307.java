package com.bruce.leetcode;

/**
 * Created by 腾 on 2016/6/6.
 */
public class RangeSumQueryMutable307 {
    public static void main(String[] args) {
        int[] nums = {1,3,5};
        NumArray array = new NumArray(nums);
        System.out.println(array.sumRange(0,2));
        array.update(1,2);
        System.out.println(array.sumRange(0,2));
    }
}
class NumArray {
    private int[] bits;
    private int[] num;
    public NumArray(int[] nums) {
        bits = new int[nums.length+1];
        num = new int[nums.length+1];
        for(int i = 0; i < nums.length; i++){
            update(i, nums[i]);
        }
    }

    void update(int i, int val) {
        int delta = val - num[i+1];
        for(int j = i+1; j < bits.length; j += j&-j){
            bits[j] += delta;
        }
        num[i+1] = val;
    }

    int getsum(int i){
        //cause 0&-0 is always 0,so increment by 1
        int sum = 0;
        for(int start = i; start > 0; start -= start&-start){
            sum += bits[start];
        }
        return sum;
    }
    public int sumRange(int i, int j) {
        return getsum(j+1) -getsum(i);
    }
}

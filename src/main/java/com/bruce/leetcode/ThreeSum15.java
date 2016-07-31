package com.bruce.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by wuteng1 on 2016/7/17.
 */
public class ThreeSum15 {
    public static void main(String[] args) {
        ThreeSum15 ts = new ThreeSum15();
//        int[] nums = {-1, 0, 1, 2, -1, -4};
//        ts.quick_sort(nums, 0, nums.length - 1);
//        for(int n: nums){
//            System.out.print(n);
//        }
//        System.out.println("----------");
        int[] nums = {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> res = ts.threeSum(nums);
        for(List<Integer> list: res){
            System.out.println(list);
        }
    }
    public List<List<Integer>> threeSum(int[] nums){
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(nums == null || nums.length < 3){
            return res;
        }
        quick_sort(nums, 0, nums.length-1);
        for(int i = 0; i < nums.length-2; i++){
            if(i > 0 && nums[i] == nums[i-1])
                continue;
            find(res, nums, i);
        }
        return res;
    }

    private void find(List<List<Integer>> res, int[] nums, int target){
        int i = target+1, j = nums.length-1;
        while(i < j){
            int sum = nums[i] + nums[j] + nums[target];
            if(sum == 0){
                List<Integer> list = new ArrayList<Integer>();
                list.add(nums[target]);
                list.add(nums[i]);
                list.add(nums[j]);
                res.add(list);
                while(i < nums.length-1 && nums[i] == nums[i+1]) {
                    i++;
                }
                while(j > 0 && nums[j] == nums[j-1]) {
                    j--;
                }
                i++;j--;
            }
            else if(sum > 0){
                j--;
            }
            else{
                i++;
            }
        }
    }

    private int quick_sort(int[] nums, int start, int end){
        if(start < end){
            int p = partition(nums, start, end);
            quick_sort(nums, start, p - 1);
            quick_sort(nums, p + 1, end);
        }
        return 0;
    }

    private int partition(int[] nums, int start, int end){
        if(start < end){
            int l = start, r = end;
            int key = nums[start];
            while(l < r){
                while(l < r && nums[r] >= key)
                    r--;
                nums[l] = nums[r];
                while(l < r && nums[l] <= key)
                    l++;
                nums[r] = nums[l];
            }
            nums[l] = key;
            /*partition(nums, start, l-1);
            partition(nums, l+1, end);*/
            return l;
        }
        else return -1;
    }

}

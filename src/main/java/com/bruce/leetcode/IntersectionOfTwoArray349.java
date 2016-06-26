package com.bruce.leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * Created by wuteng1 on 2016/6/26.
 */
public class IntersectionOfTwoArray349 {
    class Solution{
        public int[] intersection(int[] nums1, int[] nums2){
            Set<Integer> ret = new HashSet<Integer>();
            Arrays.sort(nums1);
            Arrays.sort(nums2);
            for(int num: nums1){
                if(binarySearch(num, nums2, 0, nums2.length-1)){
                    ret.add(num);
                }
            }
            int[] ans = new int[ret.size()];
            int start = 0;
            Iterator<Integer> iter = ret.iterator();
            while(iter.hasNext()){
                int num = iter.next();
                ans[start++] = num;
            }
            return ans;

        }
        private boolean binarySearch(int target, int[] nums, int i, int j){
            if(i > j)
                return false;
            int mid = (i+j) / 2;
            if(target < nums[mid]){
                return binarySearch(target, nums, i, mid-1);
            }
            else if(target > nums[mid]){
                return binarySearch(target, nums, mid+1, j);
            }
            else return true;
        }
    }
}

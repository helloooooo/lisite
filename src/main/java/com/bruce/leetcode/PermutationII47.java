package com.bruce.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by wuteng1 on 2016/6/30.
 */
public class PermutationII47 {
    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.permuteUnique(new int[]{1,1,2});
    }
    static class Solution{
        public List<List<Integer>> permuteUnique(int[] nums){
            List<List<Integer>> res = new ArrayList<List<Integer>>();
            boolean[] vis = new boolean[nums.length];
            Arrays.sort(nums);
            permute(res,  nums, new ArrayList<Integer>(), vis);
            return res;

        }

        private void permute(List<List<Integer>> res,  int[] nums, List<Integer> list, boolean[] vis){
            if(list.size() == nums.length)
                res.add(new ArrayList<Integer>(list));
            for(int i = 0; i < nums.length; i++){
                if(vis[i] || i-1 >= 0 && nums[i-1] == nums[i] && vis[i-1])
                    continue;
                list.add(nums[i]);
                vis[i] = true;
                permute(res, nums, list, vis);
                list.remove(list.size()-1);
                vis[i] = false;
            }
        }
    }
}

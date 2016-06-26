package com.bruce.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by wuteng1 on 2016/5/19.
 */
public class CombinationSumII40 {
    static class Solution{

        public List<List<Integer>> combinationSum2(int[] candidates, int target){
            List<List<Integer>> result = new ArrayList<List<Integer>>();
            if(candidates == null || candidates.length == 0)
                return result;
            Arrays.sort(candidates);
            backtrack(result, 0, candidates, target, new ArrayList<Integer>());
            return result;
        }
        public void backtrack(List<List<Integer>> result, int start, int [] candidates, int target, List<Integer> item){
             if(target == 0){
                result.add(new ArrayList<Integer>(item));
                return;
            }
            if(target < 0 || start > candidates.length)
                return;
            //1 2 2' 3    (1,2,3)与(1,2',3)等效，只需要输出一次即可
            for(int i = start; i < candidates.length; i++){
                if(i > start && candidates[i] == candidates[i - 1])
                    continue;
                item.add(candidates[i]);
                backtrack(result, i + 1, candidates, target-candidates[i], item);
                item.remove(item.size() - 1);

            }
        }
    }

    public static void main(String[] args) {
        CombinationSumII40.Solution s = new CombinationSumII40.Solution();
        int[] c = {10,1,2,7,6,1,5};
        System.out.println(s.combinationSum2(c, 8));;
    }
}

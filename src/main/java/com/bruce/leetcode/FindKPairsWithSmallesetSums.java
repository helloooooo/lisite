package com.bruce.leetcode;

import java.util.*;

/**
 * Created by wuteng1 on 2016/7/12.
 */
public class FindKPairsWithSmallesetSums {
    public static void main(String[] args) {
        FindKPairsWithSmallesetSums sum = new FindKPairsWithSmallesetSums();
        List<int[]> list = sum.kSmallestPairs(new int[]{1,1,2}, new int[]{1,2,3}, 2);
        for(int[] t:list){
            System.out.println(t[0] + ":" + t[1]);
        }
    }
    class Pair{
        int left, right;

        public Pair(int left, int right){
            this.left = left;
            this.right = right;
        }
    }

    public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k){
        Queue<Pair> queue = new PriorityQueue<Pair>(k, new Comparator<Pair>() {
            public int compare(Pair o1, Pair o2) {
                return (o2.left + o2.right) - (o1.left + o1.right);
            }
        });
        for(int i = 0; i < Math.min(nums1.length, k); i++){
            for(int j = 0; j < Math.min(nums2.length, k); j++){
                if(queue.size() < k)
                    queue.add(new Pair(nums1[i], nums2[j]));
                else if(nums1[i] + nums2[j] < queue.peek().left + queue.peek().right){
                    queue.poll();
                    queue.offer(new Pair(nums1[i], nums2[j]));
                }
            }
        }
        System.out.println(queue);
        List<int[]> list = new ArrayList<int[]>();
        while(!queue.isEmpty()){
            Pair p = queue.poll();
            int[] temp = new int[]{p.left,p.right};
            list.add(temp);
        }
        return list;
    }
}

package com.bruce.leetcode;

import java.util.*;

/**
 * Created by 腾 on 2016/7/10.
 */
public class TheSkylineProblem218 {
    public static void main(String[] args) {
        int[][] a = new int[5][4];
        for(int i = 0; i < 5; i++){
            for(int j = 0; j < 4; j++){
                a[i][j] = i * j;
            }
        }
        for(int[] b: a){
            System.out.println(b[0] + " " + b[1] + ":" + b[2]);

        }
    }
    public List<int[]> getSkyline(int[][] buildings){
        List<int[]> result =  new ArrayList<int[]>();
        List<int[]> height = new ArrayList<int[]>();
        //divide rectangle
        for(int[] b:buildings){
            //left point is negtive
            height.add(new int[]{b[0], -b[2]});
            height.add(new int[]{b[1], b[2]});
        }
        //sort the point
        Collections.sort(height, new Comparator<int[]>() {
            public int compare(int[] o1, int[] o2) {
                if(o1[0] != o2[0])
                    return o1[0] - o2[0];
                else
                    return o1[1] - o2[1];
            }
        });
        Queue<Integer> queue = new PriorityQueue<Integer>(10, new Comparator<Integer>() {
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        queue.offer(0);
        int prev = 0;
        for(int[] h: height){
            if(h[1] < 0){
                queue.offer(-h[1]);
            }
            else {
                queue.remove(h[1]);
            }
            int cur = queue.peek();
            //only after the last heightest point is removing
            if(prev != cur){
                result.add(new int[]{h[0], cur});
                prev = cur;
            }
        }
        return result;
    }
}

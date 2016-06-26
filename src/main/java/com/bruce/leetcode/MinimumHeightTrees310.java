package com.bruce.leetcode;

import java.util.*;

/**
 * Created by wuteng1 on 2016/6/8.
 */
public class MinimumHeightTrees310 {
    public static void main(String[] args) {
        Vector<Integer> list = new Vector<Integer>();
        list.add(1);
        int index = 0;
        Iterator<Integer> iter = list.iterator();
        while(iter.hasNext()){
            Integer ele = iter.next();
            System.out.println(ele);
            list.add(index++);
        }
    }
    class Solution{
        public List<Integer> findMinHeightTrees(int n, int[][] edges){
            int length = edges.length;
            List<Integer> res = new ArrayList<Integer>();
            //valid check
            //valid check
            if(n == 0)
                return res;
            else if(n == 1){
                res.add(0);
                return res;
            }
            //1.d[] is the in-degree, g[][] --> g[i] is other node that i connects to
            //ArrayList<ArrayList<Integer>> g = new ArrayList<ArrayList<Integer>>(); not good
            //Array of LinkedList
            List<Integer>[] g = new ArrayList[n];
            for(int i = 0; i < n; i++){
                g[i] = new ArrayList<Integer>();
            }
            for(int i = 0; i < length; i++){
                int v1 = edges[i][0];
                int v2 = edges[i][1];
                g[v1].add(v2);
                g[v2].add(v1);
            }
            List<Integer> leaves = new ArrayList<Integer>();
            for(int i = 0; i < n; i++){
                if(g[i].size() == 1){
                    leaves.add(i);
                }
            }
            int count = n;
            while(count > 2){
                count  -= leaves.size();
                List<Integer> newLeaves = new ArrayList<Integer>();
                for(int i = 0; i < leaves.size(); i++){
                    Integer node = leaves.get(i);
                    for(int j = 0; j < g[node].size(); j++){
                        Integer toRomove = g[node].get(j);
                        g[toRomove].remove(node);
                        if(g[toRomove].size() == 1){
                            newLeaves.add(toRomove);
                        }
                    }
                }
                leaves = newLeaves;
            }

            return leaves;
        }
    }

}

package com.bruce.leetcode;

/**
 * Created by wuteng1 on 2016/6/26.
 */
public class NumOfIslands200 {
    static class Solution{
        public int numIslands(char[][] grid){
            if(grid == null || grid.length == 0){
                return 0;
            }
            int ans = 0;
            for(int i = 0; i < grid.length; i++){
                for(int j = 0; j < grid[0].length; j++){
                    if(grid[i][j] == '1'){
                        ans ++;
                        dfs(grid, i, j);
                    }
                }
            }
            return ans;
        }
        private void dfs(char[][] grid, int i, int j){
            if(i < 0 || j < 0 || i >= grid.length || j >= grid[0].length)
                return;
            if(grid[i][j] == '1'){
                grid[i][j] = 2;
                dfs(grid, i-1, j);
                dfs(grid, i+1, j);
                dfs(grid, i, j-1);
                dfs(grid, i, j+1);
            }
        }
    }
}

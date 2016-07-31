package com.bruce.leetcode;

import java.util.Arrays;

/**
 * Created by wuteng1 on 2016/7/6.
 */
public class RangeSumQuery2DImmutable {
    static class NumMatrix{
        int[][] dp;
        public NumMatrix(int[][] matrix){
            //matrix[i][j] = matrix[i-1][j] + matrix[i][j-1] - matrix[i-1][j-1]
            if(matrix.length == 0)
                return;
            int m = matrix.length, n = matrix[0].length;
            dp = new int[m+1][n+1];
            for(int i = 1; i <= m; i++){
                for(int j = 1; j <= n; j++){
                    dp[i][j] = dp[i-1][j] + dp[i][j-1] - dp[i-1][j-1] + matrix[i-1][j-1];
                }
            }
        }

        public int sumRegion(int row1, int col1, int row2, int col2){
            return dp[row2+1][col2+1] - dp[row2+1][col1] - dp[row1][col2+1] + dp[row1][col1];
        }
    }
}

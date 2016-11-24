package com.bruce.leetcode;

/**
 * Created by wuteng1 on 2016/6/29.
 */
public class EditDistance72 {
    public static void main(String[] args) {
        Solution sol = new Solution();
        int i = sol.minDistance("aaa", "bba");
        System.out.println("i = " + i);
    }
    static class Solution{
        public int minDistance(String word1, String word2){
            //dp[i][j] = dp[i-1][j-1] if word1[i] == word2[j]
            //dp[i][j] = min{dp[i-1][j-1]//edit a char , dp[i][j-1]//delete a char in word2, dp[i-1][j]//add a char to word2}
            int len1 = word1.length(), len2 = word2.length();
            int[][] dp = new int[len1+1][len2+1];
            for(int i = 0; i <= len1; i++)
                dp[i][0] = i;
            for(int j = 0; j <= len2; j++)
                dp[0][j] = j;
            for(int i = 1; i <= len1; i++){
                for(int j = 1; j <= len2; j++){
                    char c1 = word1.charAt(i-1);
                    char c2 = word2.charAt(j-1);
                    if(c1 == c2){
                        dp[i][j] = dp[i-1][j-1];
                    }
                    else{
                        int edit = dp[i-1][j-1];
                        int delete = dp[i][j-1];
                        int add = dp[i-1][j];
                        dp[i][j] = Math.min(edit, Math.min(delete, add)) + 1;
                    }
                }
            }
            return dp[len1][len2];
        }
    }
}

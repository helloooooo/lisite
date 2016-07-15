package com.bruce.leetcode;

/**
 * Created by 腾 on 2016/6/27.
 */
public class InterleavingString97 {
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.isInterleave("aabcc","dbbca","aadbbcbcac"));
    }
    static class Solution{
        public boolean isInterleave(String s1, String s2, String s3){
            int len1 = s1.length(), len2 = s2.length(), len3 = s3.length();
            if(len1 + len2 != len3)
                return false;
            boolean[][] match = new boolean[len1+1][len2+1];
            if(len1 == 0 && len2 == 0){
                if(len3 == 0)
                    return true;
                else return false;
            }
            for(int i = 1; i <= len1; i++){
                if(s1.charAt(i-1) == s3.charAt(i-1)){
                    match[i][0] = true;
                }
                else break;
            }
            for(int i =1; i <= len2; i++){
                if(s2.charAt(i-1) == s3.charAt(i-1)){
                    match[0][i] = true;
                }
                else break;
            }
            for(int i = 1; i <= len1; i++){
                for(int j = 1; j <= len2; j++){
                    int temp = i+j;
                    if(s1.charAt(i-1) == s3.charAt(temp-1)){
                        match[i][j] = match[i][j] || match[i-1][j];
                    }
                    if(s2.charAt(j-1) == s3.charAt(temp-1)){
                        match[i][j] = match[i][j] || match[i][j-1];
                    }
                }
            }
            return match[len1][len2];
        }
    }
}

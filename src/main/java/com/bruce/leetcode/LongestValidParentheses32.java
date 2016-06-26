package com.bruce.leetcode;

/**
 * Created by wuteng1 on 2016/6/18.
 */
public class LongestValidParentheses32 {
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.longestValidParentheses("(())"));
    }
    static class Solution{
        public int longestValidParentheses(String s){
            int len = s.length();
            char[] str = new char[2+len];
            str[0]=str[len+1]='#';
            for(int i = 1;i < len+1; i++)
                str[i] = s.charAt(i-1);
            int[] dp = new int[len+2];
            for(int i = 0; i < len+2; i++){
                dp[i] = -1;
            }
            for(int i = len; i >= 1; i--){
                if(str[i] == '('){
                    if(str[i+1] == ')'){
                        dp[i] = i+1;
                    }
                    else{
                        int j=i+1 ;
                        while(str[j] == '(' && dp[j] != -1){
                            j = dp[j]+1;
                        }
                        if(str[j] == ')')
                            dp[i] = j;
                    }
                }
            }
            int cur = 0, longest = 0;
            for(int i = 0; i <= len+1; ){
                if(dp[i] != -1){
                    cur += dp[i] - i + 1;
                    i = dp[i]+1;
                }
                else{
                    longest = Math.max(longest, cur);
                    cur = 0;
                    i+=1;
                }
            }
            return longest;
        }
    }
}

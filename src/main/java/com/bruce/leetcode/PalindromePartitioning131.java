package com.bruce.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by wuteng1 on 2016/6/29.
 */
public class PalindromePartitioning131 {
    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.partition("aab");
    }
    static class Solution{
        public List<List<String>> partition(String s){
            List<List<String>> res = new ArrayList<List<String>>();
            ArrayList<String> list = new ArrayList<String>();
            if(s == null || s.length() == 0)
                return res;
            calResult(res, list, s);
            System.out.println(res);
            return res;
        }
        private void calResult(List<List<String>> result, ArrayList<String> list, String s){
            int len = s.length();
            if(len == 0)
                result.add(new ArrayList<String>(list));
            for(int i = 1; i <= len; i++){
                String str = s.substring(0, i);
                if(isPalindrome(str)){
                    list.add(str);
                    calResult(result, list, s.substring(i));
                    list.remove(list.size()-1);
                }
            }
        }
        private boolean isPalindrome(String str){
            for(int i=0 ; i < str.length()/2; i++){
                if(str.charAt(i) != str.charAt(str.length() -1 - i))
                    return false;
            }
            return true;
        }
    }
}

package com.bruce.leetcode;

/**
 * Created by wuteng1 on 2016/6/28.
 */
public class ReversingWordsInAString151 {
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.reverseWords("   a   b "));
    }
    static class Solution{
        public String reverseWords(String s){
            /*
            Could the input string contain leading or trailing spaces?
            Yes. However, your reversed string should not contain leading or trailing spaces.
            How about multiple spaces between two words?
            Reduce them to a single space in the reversed string.
             */
            s = s.trim();
            char[] src = s.toCharArray(); char[] arr = new char[s.length()];
            int index = 0;
            for(int i = 0; i < src.length; i++){
                if(src[i] != ' '){
                    arr[index++] = src[i];
                }
                else{
                    if(arr[index-1] != ' ')
                        arr[index++] = src[i];
                }
            }
            reverseCharArray(arr, 0, index);
            for(int i = 0, j = 0; j <= index; j++){
                if(j == index || arr[j] == ' '){
                    reverseCharArray(arr, i, j);
                    i = j + 1;
                }
            }
            return new String(arr, 0, index);
        }

        public void reverseCharArray(char[] s, int start, int end){
            int mid = (end-start)/2;
            for(int i = 0; i < mid; i++){
                char temp = s[start+i];
                s[start+i] = s[end-1-i];
                s[end-1-i] = temp;
            }
        }
    }
}

package com.bruce.leetcode;

/**
 * Created by wuteng1 on 2016/7/5.
 */
public class IntegetToEnglishWords273 {
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.convertHandred(123));
        System.out.println(sol.numberToWords(0));
        System.out.println(sol.numberToWords(1000000));
    }
    static class Solution{
        public String numberToWords(int num){
            String res = convertHandred(num % 1000);
            String[] v3 = {"Thousand", "Million", "Billion"};
            for(int i = 0; i < 3; i++){
                num /= 1000;
                res = num % 1000 > 0 ? convertHandred(num % 1000) + " " + v3[i] + " " + res : res;
            }
            if(res.equals(""))
                res = "Zero";
            return res.trim();
        }

        private String convertHandred(int num){
            String[] v1 = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
            String[] v2 = {"", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
            String res = "";
            int a = num / 100, b = num % 100, c = num % 10;
            res = b <= 19 ? v1[b] : v2[b/10] + (c > 0 ? " " + v1[c]: "");
            res = a > 0 ? v1[a] + " Hundred" + (b > 0 ? " " + res: "") : res;
            return res;
        }
    }
}

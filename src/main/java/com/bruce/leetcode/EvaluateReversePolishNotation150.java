package com.bruce.leetcode;

import java.util.Stack;

/**
 * Created by wuteng1 on 2016/6/28.
 */
public class EvaluateReversePolishNotation150 {
    public static void main(String[] args) {
        Solution sol = new Solution();
        String[] res = {"2","1","+","3","*"};
        System.out.println(sol.evalRPN(res));
    }
    static class Solution{
        public int evalRPN(String[] tokens){
            Stack<Integer> sk = new Stack<Integer>();
            for(String s: tokens){
                if(s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/")){
                    operate(s, sk);
                }
                else{
                    sk.push(Integer.parseInt(s));
                }

            }
            return sk.pop();
        }

        private void operate(String operator, Stack<Integer> sk){
            if(sk.size() >= 2){
                Integer t2 = sk.pop();
                Integer t1 = sk.pop();
                if(operator.equals("+")){
                    sk.push(t1 + t2);
                }
                else if(operator.equals("-")){
                    sk.push(t1 - t2);
                }
                else if(operator.equals("*")){
                    sk.push(t1 * t2);
                }
                else if(operator.equals("/")){
                    sk.push(t1 / t2);
                }
            }
        }
    }
}

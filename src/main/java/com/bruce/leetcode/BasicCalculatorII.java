package com.bruce.leetcode;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Created by wuteng1 on 2016/7/21.
 */
public class BasicCalculatorII {
    public static void main(String[] args) {
    }
    public int calculate(String s){
        Stack<Integer> nums = new Stack<Integer>();
        char sign = '+';
        int d = 0, res = 0;
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(c >= '0' && c <= '9'){
                d = d * 10 + (c - '0');
            }
            if(c < '0' && c != ' ' || i == s.length()-1){
                if(sign == '+')
                    nums.push(d);
                else if(sign == '-')
                    nums.push(-d);
                else{
                    int lastNum = nums.pop();
                    int temp = (sign == '*' ? lastNum * d : lastNum / d);
                    nums.push(temp);
                }
                sign = c;
                d = 0;
            }
        }
        while(!nums.isEmpty()){
            res += nums.pop();
        }
        return res;
    }

}

package com.bruce.leetcode;

import org.apache.commons.lang.StringUtils;

import java.util.Iterator;
import java.util.Stack;

/**
 * Created by wuteng1 on 2016/6/30.
 */
public class SimplifyPath71 {
    public static void main(String[] args) {
        //Solution sol = new Solution();
        //System.out.println(sol.simplifyPath("/a/./b/../../c/"));
        String str[] = "//a/".split("/");
        System.out.println(str.length);
        for(String s: str){
            System.out.println(s);
        }
    }
    static class Solution{
        public String simplifyPath(String path){
            String[] paths = path.split("/");
            Stack<String> sk = new Stack<String>();
            for(String s: paths){
                if(s.equals("..")){
                    if(!sk.isEmpty()){
                        sk.pop();
                    }
                }
                else if(s.length() == 0 || s.equals(".")){
                    continue;
                }
                else{
                    sk.push(s);
                }
            }
            if(sk.isEmpty())
                sk.push("");
            Iterator<String> iter = sk.iterator();
            StringBuffer sb = new StringBuffer();
            while(iter.hasNext()){
                String s = iter.next();
                sb.append("/");
                sb.append(s);
            }
            return sb.toString();
        }
    }
}

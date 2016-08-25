package com.bruce.baselearning.utility;

/**
 * Created by wuteng1 on 2016/8/16.
 */
public class SplitDemo {
    public static void main(String[] args) {
        String a = "___1__2_";
        String[] split = a.split("_");
        for(String s: split){
            System.out.println(s);
        }
        System.out.println("**********");
    }
}

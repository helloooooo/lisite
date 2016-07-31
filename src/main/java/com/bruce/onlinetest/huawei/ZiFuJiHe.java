package com.bruce.onlinetest.huawei;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * Created by wuteng1 on 2016/7/18.
 */
public class ZiFuJiHe {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            Set<Character> set = new LinkedHashSet<Character>();
            String input = scanner.next();
            for(char c: input.toCharArray()){
                set.add(c);
            }
            StringBuffer sb = new StringBuffer();
            for(Character c: set){
                sb.append(c);
            }
            System.out.println(sb.toString());
        }
    }
}

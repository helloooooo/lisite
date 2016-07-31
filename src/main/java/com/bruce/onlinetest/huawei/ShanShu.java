package com.bruce.onlinetest.huawei;

import java.util.Scanner;

/**
 * Created by wuteng1 on 2016/7/18.
 */
public class ShanShu {
    public static void main(String[] args) {
        //f(m,k,i)  = (k-1) % m, if i = 1
        //f(m,k,i) = f(m-1, k, i-1) + k % m
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            int n = scanner.nextInt();
            System.out.println(fun(n, 3, n));
        }
    }
    //0 1 2 3 4 5 6 7
    //0 1   3 4 5 6 7
    //3 4 5 6 7 0 1 *
    //0 1 2 3 4 5 6 **
    //(** + k) % m
    private static int fun(int m, int k, int i){
        if(i == 1)
            return (k-1) % m;
        else
            return (fun(m-1, k, i-1) + k )% m;
    }
}

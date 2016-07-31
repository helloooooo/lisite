package com.bruce.concurrentdemo.demo;

import java.io.FilterInputStream;
import java.util.Scanner;

/**
 * Created by wuteng1 on 2016/7/30.
 *
 1 10 2
 12 23 3
 6 19 5
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            int start = scanner.nextInt();
            int end = scanner.nextInt();
            int k = scanner.nextInt();
            int cnt = 0;
            for(int i = start; i <= end; i++){
                cnt += prime_num(i, k);
            }
            System.out.println(cnt);
        }
    }

    public static int prime_num(int n, int k){
        int m = n;
        int cnt = 0;
        for(int i = 2; i <= n; i++){
            if(n % i == 0){
                while(m % i == 0){
                    if(i < k)
                        return 0;
                    if(i == k)
                        cnt = 1;
                    m = m/i;

                }
            }

        }
        return cnt;
    }
}

package com.bruce.concurrentdemo.chapter8;

import java.util.concurrent.CountDownLatch;

/**
 * Created by wuteng1 on 2016/8/11.
 */
public class CountDownLatchTest {
    static CountDownLatch countDownLatch = new CountDownLatch(2);

    public static void main(String[] args) throws InterruptedException {
        new Thread(new Runnable() {
            public void run() {
                System.out.println(1);
                countDownLatch.countDown();
                System.out.println(2);
                countDownLatch.countDown();
            }
        }).start();
        countDownLatch.await();
        System.out.println(3);

    }
}

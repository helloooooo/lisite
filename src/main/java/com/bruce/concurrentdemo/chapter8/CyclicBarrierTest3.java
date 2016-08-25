package com.bruce.concurrentdemo.chapter8;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * Created by wuteng1 on 2016/8/11.
 */
public class CyclicBarrierTest3 {

    static CyclicBarrier c = new CyclicBarrier(2);

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new Runnable() {
            public void run() {
                try {
                    c.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
                System.out.println(1);
            }
        });
        thread.start();
        thread.interrupt();

        Thread.sleep(300);
        try {
            c.await();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
            System.out.println(c.isBroken());
        }
        System.out.println(2);
    }
}

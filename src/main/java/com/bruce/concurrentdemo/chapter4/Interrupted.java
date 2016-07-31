package com.bruce.concurrentdemo.chapter4;

import java.util.concurrent.TimeUnit;

/**
 * Created by wuteng1 on 2016/7/20.
 */
public class Interrupted {

    public static void main(String[] args) throws InterruptedException {

        Thread sleepThread = new Thread(new SleepRunner(), "SleepThread");
        sleepThread.setDaemon(true);

        Thread busyThread = new Thread(new BusyRunner(), "BusyThread");
        busyThread.setDaemon(true);

        sleepThread.start();
        busyThread.start();

        TimeUnit.SECONDS.sleep(5);
        sleepThread.interrupt();
        busyThread.interrupt();
        System.out.println("SleepThread interrupted is " + sleepThread.isInterrupted());
        System.out.println("BusyThread interruped is " + busyThread.isInterrupted());
        //busy thread is running all the time, when calling interrupt, next time it stops running
        //sleep thread is waiting when calling interrupt, so jvm reset isInterrupted to be false.
        SleepUtils.second(2);
    }
    static class SleepRunner implements Runnable{

        public void run() {
            while(true){
                try {
                    SleepUtils.second(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("haha");
            }
        }
    }

    static class BusyRunner implements Runnable{

        public void run() {
            while(true){
            }
        }
    }
}


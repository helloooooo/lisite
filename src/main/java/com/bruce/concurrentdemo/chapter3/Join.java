package com.bruce.concurrentdemo.chapter3;

import java.util.concurrent.TimeUnit;

/**
 * Created by wuteng1 on 2016/7/20.
 */
public class Join {
    static class Domino implements Runnable{
        private Thread thread;

        public Domino(Thread thread) {
            this.thread = thread;
        }

        public void run() {
            try{
                TimeUnit.SECONDS.sleep(2);
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " terminated");
        }

        public static void main(String[] args) throws InterruptedException {
            Thread previous = Thread.currentThread();
            for(int i = 0; i < 10; i++){
                Thread thread = new Thread(new Domino(previous), String.valueOf(i));
                thread.start();
                previous = thread;
            }
            TimeUnit.SECONDS.sleep(5);
            System.out.println(Thread.currentThread().getName() + " terminated");
        }
    }
}

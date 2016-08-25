package com.bruce.concurrentdemo.chapter5;

import com.bruce.concurrentdemo.chapter4.SleepUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Lock;

/**
 * Created by wuteng1 on 2016/7/30.
 */
public class TwinsLockTest {
    public static void main(String[] args) {
        String a  = "ope:1,2";
        System.out.println(a.indexOf(':'));
        List<Object> list = new ArrayList<Object>();
        Object o1 = new Object();
        Object o2 = new Object();
        list.add(o1);
        list.add(o2);
//        list.remove(o1);
        System.out.println(list);
    }
    public void test(){
        final Lock lock = new TwinsLock();
        class Work extends Thread{
            @Override
            public void run() {
                while (true){
                    lock.lock();
                    try {
                        SleepUtils.second(1);
                        System.out.println(Thread.currentThread().getName());
                        SleepUtils.second(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}

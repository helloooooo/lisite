package com.bruce.concurrentdemo.chapter5;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by wuteng1 on 2016/10/21.
 */
public class BlockedQueue<T> {
    private Object[] items;
    private int addIndex, removeIndex, count;
    private Lock lock = new ReentrantLock();
    private Condition notFull = lock.newCondition();
    private Condition notEmpty = lock.newCondition();

    public BlockedQueue(int size){
        items = new Object[size];
    }

    public void add(T t){
        lock.lock();
        while(count == items.length){
            try {
                notFull.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            items[addIndex] = t;
            if(++addIndex == items.length){
                addIndex = 0;
            }
            ++count;
            notEmpty.signal();
        }
    }



}

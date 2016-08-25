package com.bruce.concurrentdemo.chapter5;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by wuteng1 on 2016/8/14.
 */
public class BoundedQueue2<T> {
    Object[] elements;
    private int insertIndex = 0, removeIndex = 0, count = 0;
    private Lock lock = new ReentrantLock();
    Condition notFull = lock.newCondition();
    Condition notEmpty = lock.newCondition();

    public BoundedQueue2(int size){
        elements = new Object[size];
    }

    public void add(T t) throws InterruptedException {
        lock.lock();
        try{
            while(count == elements.length){
                notFull.wait();
            }
            elements[insertIndex++] = t;
            count++;
            if(insertIndex == elements.length){
                insertIndex = 0;
            }
            notEmpty.signal();

        }finally {
            lock.unlock();
        }
    }

    public T remove(){
        lock.lock();
        try{
            while(count == 0){
                notEmpty.signal();
            }
            T t = (T) elements[removeIndex++];
            count--;
            if(removeIndex == elements.length){
                removeIndex = 0;
            }
            notFull.signal();
            return t;
        }finally {
            lock.unlock();
        }
    }

}

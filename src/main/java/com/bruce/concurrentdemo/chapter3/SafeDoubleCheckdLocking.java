package com.bruce.concurrentdemo.chapter3;

/**
 * Created by wuteng1 on 2016/7/20.
 */
public class SafeDoubleCheckdLocking {
    private volatile static Instance instance;

    public static Instance getInstance(){
        if(instance == null){
            synchronized (SafeDoubleCheckdLocking.class){
                if(instance == null)
                    instance = new Instance();
            }
        }
        return instance;
    }

}

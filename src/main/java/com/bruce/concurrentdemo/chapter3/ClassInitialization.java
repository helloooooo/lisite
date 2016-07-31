package com.bruce.concurrentdemo.chapter3;

/**
 * Created by wuteng1 on 2016/7/20.
 */
public class ClassInitialization {
    private static class InstanceHolder{
        public static Instance instance = new Instance();
    }

    public Instance getInstance(){
        return InstanceHolder.instance;
    }

}

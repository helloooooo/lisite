package com.bruce.concurrentdemo.chapter4;

/**
 * Created by wuteng1 on 2016/7/21.
 */
public interface ThreadPool<Job extends Runnable> {
    //Job is a generic class
    void execute(Job job);

    void shutdown();    //shutdown the thread pool

    void addWorkers(int num);

    void removeWorkers(int num);

    int getJobSize();
}

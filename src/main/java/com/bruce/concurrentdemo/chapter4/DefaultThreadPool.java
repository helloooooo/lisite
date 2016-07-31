package com.bruce.concurrentdemo.chapter4;


import javafx.concurrent.Worker;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by wuteng1 on 2016/7/21.
 */
public class DefaultThreadPool<Job extends Runnable> implements ThreadPool<Job>{

    private static final int MAX_WORKER_NUMBERS = 10;

    private static final int DEFAULT_WORKER_NUMBERS = 5;

    private static final int MIN_WORKER_NUMBERS = 1;

    private final LinkedList<Job> jobs = new LinkedList<Job>();

    private final List<Worker> workers = Collections.synchronizedList(new ArrayList<Worker>());

    private int workerNum = DEFAULT_WORKER_NUMBERS;

    private AtomicLong threadNum = new AtomicLong();



    public void execute(Job job) {
        if(job != null){
            synchronized (jobs){
                jobs.addLast(job);
                jobs.notify();
            }
        }
    }

    public void shutdown() {
        for(Worker worker: workers){
            worker.shutdown();
        }
    }

    private void initializeWorkers(int num){
        for(int i = 0; i < num; i++){
            Worker worker = new Worker();
            workers.add(worker);
            Thread thread = new Thread(worker, "ThreadPool-Worker-" + threadNum.incrementAndGet());
            thread.start();
        }

    }

    public void addWorkers(int num) {
        //lock the jobs list
        synchronized (jobs){
            if(num + this.workerNum > MAX_WORKER_NUMBERS){
                num = MAX_WORKER_NUMBERS - this.workerNum;
            }
            initializeWorkers(num);
            this.workerNum += num;
        }
    }

    public void removeWorkers(int num) {
        synchronized (jobs){
            if(num >= this.workerNum){
                throw new IllegalArgumentException("beyond workNum");
            }
            int count = 0;
            while(count < num){
                Worker worker = workers.get(count);
                if(workers.remove(worker)){
                    count++;
                    worker.shutdown();
                }
            }
            this.workerNum -= num;
        }
    }

    public int getJobSize() {
        return jobs.size();
    }

    class Worker implements Runnable{
        private volatile boolean running = true;
        public void run() {
            while(running){
                Job job = null;
                synchronized (jobs){
                    while(jobs.isEmpty()){
                        try {
                            jobs.wait();   //wait untils other thread call notify or notifyall in jobs
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                            return;
                        }
                    }
                    job = jobs.removeFirst();
                }
                if(job != null){
                    job.run();
                }

            }
        }

        public void shutdown(){
            running = false;
        }
    }
}

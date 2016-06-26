package com.bruce.concurrentdemo;

import java.util.concurrent.*;

/**
 * Created by wuteng1 on 2016/6/23.
 */
public class Test {

    public static void main(String[] args) {
        ExecutorService executor = Executors.newCachedThreadPool();
        Task task = new Task();
        //Future<Integer> result = executor.submit(task);

        FutureTask<Integer> futureTask = new FutureTask<Integer>(task);
        executor.submit(futureTask);

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Main thread is running!");
        try {
            //System.out.println("task running result: " + result.get());
            System.out.println("task running result: " + futureTask.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        System.out.println("All thread is running over!");
        executor.shutdown();

    }

}

class Task implements Callable<Integer>{

    public Integer call() throws Exception {
        System.out.println("Child thread is running!");
        Thread.sleep(3000);
        int sum = 0;
        for(int i = 0; i < 100; i++){
            sum += i;
        }
        return sum;
    }
}
package com.bruce.multithreadprogramming;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by wuteng1 on 2016/5/18.
 */
public class ExecutorServiceDemo {
    public static Log logger = LogFactory.getLog(ExecutorServiceDemo.class);
    public static void main(String[] args) {

        /*ExecutorService executorService = Executors.newFixedThreadPool(10);
        executorService.execute(new Runnable() {
            public void run() {
                logger.info("Asynchronous task");
            }
        });
        executorService.shutdown();*/

        ExecutorService executorService = Executors.newSingleThreadExecutor();

        Set<Callable<String>> callables = new HashSet<Callable<String>>();

        callables.add(new Callable<String>() {
            public String call() throws Exception {
                return "task 1";
            }
        });
        callables.add(new Callable<String>() {
            public String call() throws Exception {
                return "task 2";
            }
        });
        callables.add(new Callable<String>() {
            public String call() throws Exception {
                return "task 3";
            }
        });

        String result = null;
        try {
            //一旦某个线程抛出异常，方法会取消其他callable的执行
            result = executorService.invokeAny(callables);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        logger.info("result = " + result);
        executorService.shutdown();
    }

}

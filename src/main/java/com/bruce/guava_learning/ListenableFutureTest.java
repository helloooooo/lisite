package com.bruce.guava_learning;

import com.google.common.collect.Interner;
import com.google.common.util.concurrent.*;
import org.junit.Test;

import java.sql.Time;
import java.util.Random;
import java.util.concurrent.*;

/**
 * Created by wuteng1 on 2016/9/7.
 */
public class ListenableFutureTest {
    public static void main(String[] args) {
//        new Thread(new Runnable() {
//            public void run() {
//                try {
//                    TimeUnit.SECONDS.sleep(10);
//                    System.out.println("xixi");
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//        }).start();
//        System.out.println("main thread over");

        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Future<Integer> submit = executorService.submit(new Callable<Integer>() {
            public Integer call() throws Exception {
                TimeUnit.SECONDS.sleep(2);
                System.out.println("xixi");
                return 1;
            }
        });
        try {
            System.out.println(submit.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void testListenableFutureTest(){
        ListeningExecutorService executorService  = MoreExecutors.listeningDecorator(Executors.newCachedThreadPool());
        final ListenableFuture<Integer> listenableFuture = executorService.submit(new Callable<Integer>() {
            public Integer call() throws Exception {
                System.out.println("call execute....");
                TimeUnit.SECONDS.sleep(1);
                System.out.println("xixi");
                return 7;
            }
        });
        Futures.addCallback(listenableFuture, new FutureCallback<Integer>() {
            public void onSuccess(Integer integer) {
                System.out.println("get listenable future's result with callback " + integer);
            }

            public void onFailure(Throwable throwable) {
                throwable.printStackTrace();
            }
        });
//        listenableFuture.addListener(new Runnable() {
//            public void run() {
//                try {
//                    System.out.println("get result from future " + listenableFuture.get());
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                } catch (ExecutionException e) {
//                    e.printStackTrace();
//                }
//            }
//        }, executorService);

    }
    @Test
    public void testChainAsync(){
        class Task1 implements Callable<Integer>{

            public Integer call() throws Exception {
                System.out.println("task1 begin");
                Thread.sleep(2000);
                System.out.println("task1 ends");
                return new Random().nextInt(10);
            }
        }

        class Task2 implements Callable<String>{
            private Integer i;
            public Task2(Integer i){
                this.i = i;
            }

            public String call() throws Exception {
                System.out.println("task2 begin");
                Thread.sleep(4000);
                System.out.println("task2 end");
                return i + "suffix";
            }
        }

        ExecutorService normalService = Executors.newCachedThreadPool();
        final ListeningExecutorService service = MoreExecutors.listeningDecorator(normalService);
        ListenableFuture<Integer> future1 = service.submit(new Task1());
        AsyncFunction<Integer, String> asyncFunction = new AsyncFunction<Integer, String>() {
            public ListenableFuture<String> apply(Integer input) throws Exception {
                return service.submit(new Task2(input));
            }
        };
        ListenableFuture<String> future2 = Futures.transform(future1, asyncFunction);
        try {
            System.out.println(future2.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}

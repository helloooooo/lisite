package com.bruce.concurrentdemo.chapter4;

import java.sql.Connection;
import java.util.LinkedList;

/**
 * Created by wuteng1 on 2016/7/20.
 */
public class ConnectionPool {
    private LinkedList<Connection> pool = new LinkedList<Connection>();

    public ConnectionPool(int initialSize) {
        if(initialSize > 0){
            for(int i = 0; i < initialSize; i++){
                pool.add(ConnectionDriver.createConnection());
            }
        }
        System.out.println(pool.size());
    }

    public void releaseConnection(Connection connection){
        if(connection != null){
            synchronized (pool){
                System.out.println("releasing");
                pool.addLast(connection);
                pool.notify();
            }
        }
    }

    public Connection fetchConnection(long mills) throws InterruptedException {
        synchronized (pool){
            if(mills <= 0){
                while(pool.isEmpty()){
                    pool.wait();
                }
                return pool.removeFirst();
            }
            else{
                long future = mills + System.currentTimeMillis();
                long remaining = mills;
                while(pool.isEmpty() && remaining > 0){
                    pool.wait(remaining);
                    remaining = future - System.currentTimeMillis();
                }
                Connection result = null;
                if(!pool.isEmpty()){
                    System.out.println("removing");
                    result = pool.removeFirst();
                }
                return result;
            }

        }
    }
}

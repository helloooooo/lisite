package com.bruce.concurrentdemo.chapter4;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.sql.Connection;
import java.util.concurrent.TimeUnit;

/**
 * Created by wuteng1 on 2016/7/20.
 */
public class ConnectionDriver {
    static class ConnectionHandler implements InvocationHandler{

        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            if(method.getName().equals("commit")){
                System.out.println("haha");
                TimeUnit.MICROSECONDS.sleep(100);
            }
            return null;
        }

    }
    public static final Connection createConnection(){
        return (Connection) Proxy.newProxyInstance(ConnectionDriver.class.getClassLoader(), new Class<?>[]{Connection.class}, new ConnectionHandler());
    }
}

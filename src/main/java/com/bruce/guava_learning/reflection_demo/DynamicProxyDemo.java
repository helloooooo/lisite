package com.bruce.guava_learning.reflection_demo;

import com.google.common.reflect.Reflection;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by wuteng1 on 2016/9/17.
 */
public class DynamicProxyDemo {
    public static void main(String[] args) {
        InvocationHandler invocationHandler = new MyInvocationHandler();
        //Guava Dynamic Proxy Implement
        IFoo foo = Reflection.newProxy(IFoo.class, invocationHandler);
        foo.doSomething();
        //Jdk Dynamic proxy implements
        IFoo jdkFoo = (IFoo) Proxy.newProxyInstance(IFoo.class.getClassLoader(), new Class<?>[]{IFoo.class}, invocationHandler);
        jdkFoo.doSomething();
    }

    public static class MyInvocationHandler implements InvocationHandler{

        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            System.out.println("proxy prints something");
            return null;
        }
    }

    public static interface IFoo{
        void doSomething();
    }
}

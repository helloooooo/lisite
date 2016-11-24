package com.bruce.guava_learning.reflection_demo;

import com.google.common.reflect.Invokable;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/**
 * Created by wuteng1 on 2016/9/18.
 */
public class InvokableDemo {
    public static void main(String[] args) {
        Class<?> demo = null;
        try {
            demo = Class.forName("com.bruce.guava_learning.reflection_demo.Human");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        Method[] methods = demo.getDeclaredMethods();
        for(int i = 0; i < methods.length; i++){
            Invokable invokable = Invokable.from(methods[i]);
            //jdk use case
            System.out.println(methods[i].getName() + " jdk usecase: " + Modifier.isPublic(methods[i].getModifiers()));
            //guava use case
            System.out.println(methods[i].getName() + " guava usecase: " + invokable.isPublic());
        }
    }
}

class Human{
    public int sum(int a, int b){
        return a+b;
    }
    private void print(){
        System.out.println("hello, world!");
    }
}

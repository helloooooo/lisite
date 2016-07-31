package com.bruce.reflect_demo;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * Created by wuteng1 on 2016/7/13.
 */
public class ReflectDemo {
    private int a, b;
    class A{
        public A(int i, int j){

        }
        public A(String a, String b){

        }
    }
    public ReflectDemo(int a){

    }
    public ReflectDemo(int a, int b){
        this.a = a;
        this.b = b;
    }
    public void print(){
        System.out.println(a+b);
    }
    public static void main(String[] args) {
        Class[] cls = new Class[]{int.class, int.class};
        Object[] params = new Object[]{new Integer(1), new Integer(2)};
        try {
            Constructor c = Thread.currentThread().getContextClassLoader().loadClass("com.bruce.reflect_demo.ReflectDemo").getConstructor(cls);
            ReflectDemo r = (ReflectDemo) c.newInstance(params);
            r.print();
            System.out.println(c);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}

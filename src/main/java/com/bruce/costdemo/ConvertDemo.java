package com.bruce.costdemo;

import org.junit.Test;

/**
 * Created by wuteng1 on 2016/9/20.
 */
public class ConvertDemo {

    public static void main(String[] args) throws Exception{
        String val = "a";
        int a = 1;
        a = Integer.valueOf(val);
        System.out.println("a = " + a);
    }

    @Test
    public void testConvert(){
        Parent p = new Parent();
        p.say();
        Class<? extends Parent> pClass = p.getClass();
        try {
            Parent parent = pClass.newInstance();
            parent.say();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
//        try {
////            Parent parent = convert(p.getClass());
////            parent.say();
////            Child child = convert(Child.class);
////            child.say();
//
//        } catch (IllegalAccessException e) {
//            e.printStackTrace();
//        } catch (InstantiationException e) {
//            e.printStackTrace();
//        }
    }
    public <T> T convert(Class<T> clazz) throws IllegalAccessException, InstantiationException {
        T t = clazz.newInstance();
        return t;
    }

    class Parent{
        public Parent() {
        }

        public void say(){
            System.out.println("A saying.");
        }
    }

    class Child extends Parent{
        public Child() {
        }

        public void say(){
            System.out.println("B saying");
        }
    }
}

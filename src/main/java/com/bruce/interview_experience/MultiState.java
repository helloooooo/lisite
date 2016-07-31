package com.bruce.interview_experience;


import com.bruce.clonedemo.demo1.Person;

/**
 * Created by 腾 on 2016/7/11.
 */
public class MultiState {
    static class Father{
        private void fun1(){
            fun2();
        }
        public void fun2(){
            System.out.println("AAA");
        }
    }

    static class Child extends Father{
        private void fun1(int i){
            System.out.println("BBB");
        }
        public void fun2(){
            System.out.println("CCC");
        }
    }

    public static void main(String[] args) {
        Father child = new Child();
        child.fun1();
        EqualsDemo.Person p = new EqualsDemo.Person("ha");
    }
}

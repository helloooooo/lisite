package com.bruce.baselearning.reflection.chapter1;

import java.util.Comparator;

/**
 * Created by wuteng1 on 2016/8/13.
 */
public class StrongPerson extends Creature<String> implements MyInterface, Comparator {
    private String name;
    private int age;

    public StrongPerson() {
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public StrongPerson(String name, int age) {

        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public void show(){
        System.out.println("Hello, tencent");
    }
    @MyAnnotation()
    public void display(String country){
        System.out.println("i came from " + country);
    }

    public int compare(Object o1, Object o2) {
        return 0;
    }

    class bird{

    }
}

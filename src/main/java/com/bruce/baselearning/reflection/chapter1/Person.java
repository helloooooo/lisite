package com.bruce.baselearning.reflection.chapter1;

/**
 * Created by wuteng1 on 2016/8/13.
 */
public class Person {

    private String name;
    private int age;

    public Person() {
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

    public Person(String name, int age) {

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

    public void display(String country){
        System.out.println("i came from " + country);
    }
}

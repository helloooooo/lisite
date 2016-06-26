package com.bruce.clonedemo.demo1;

/**
 * Created by wuteng1 on 2016/6/22.
 */
public class Person implements Cloneable{
    private int age;
    private String name;
    public Person(int age, String name){
        this.age = age;
        this.name = name;
    }
    public Person(){}

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}

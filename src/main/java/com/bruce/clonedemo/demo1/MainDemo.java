package com.bruce.clonedemo.demo1;

/**
 * Created by wuteng1 on 2016/6/22.
 */
public class MainDemo {
    public static void main(String[] args) throws CloneNotSupportedException {
        Person p = new Person(23, "zhang");
        Person p1 = (Person) p.clone();
        String result = p.getName() == p1.getName() ? "clone浅拷贝":"clone深拷贝";
        System.out.println(result);
    }

}

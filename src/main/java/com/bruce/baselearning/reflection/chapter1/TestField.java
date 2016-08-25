package com.bruce.baselearning.reflection.chapter1;

import org.junit.Test;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

/**
 * Created by wuteng1 on 2016/8/13.
 */
public class TestField {

    @Test
    public void test2(){
        Class clazz = StrongPerson.class;
        Field[] declaredFields = clazz.getDeclaredFields();
        for(Field f: declaredFields){
            System.out.println(Modifier.toString(f.getModifiers()));
            System.out.println(f.getType().getName());
            System.out.println(f.getName());
            System.out.println("********************");
        }

    }
    @Test
    public void test1(){
        Class clazz = StrongPerson.class;
        //can only get the public field and it's super class
        Field[] fields = clazz.getFields();
        for(Field field: fields){
            System.out.println(field);
        }

        System.out.println("********************");
        //get the declared fields in this class
        Field[] declaredFields = clazz.getDeclaredFields();
        for(Field f: declaredFields){
            System.out.println(f);
        }
    }
}

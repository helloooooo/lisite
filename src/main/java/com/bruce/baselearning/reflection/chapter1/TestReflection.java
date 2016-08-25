package com.bruce.baselearning.reflection.chapter1;

import org.junit.Test;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by wuteng1 on 2016/8/13.
 */
public class TestReflection {

    @Test
    public void testClassLoader() throws ClassNotFoundException {
        ClassLoader classLoader1 = ClassLoader.getSystemClassLoader();
        System.out.println(classLoader1);

        ClassLoader classLoader2 = classLoader1.getParent();
        System.out.println(classLoader2);
        ClassLoader classLoader3 = classLoader2.getParent();
        System.out.println(classLoader3);
        System.out.println("***********************");
        String className = "java.lang.Object";
        Class clazz = Class.forName(className);
        ClassLoader loader =  clazz.getClassLoader();
        System.out.println(loader);


    }

    @Test
    public void testCreateClazz() throws ClassNotFoundException {

        String className = "com.bruce.baselearning.reflection.chapter1.Person";
        Class clazz = Class.forName(className);
        System.out.println(clazz.getName());
        System.out.println("************");

        Class clazz2 = this.getClass().getClassLoader().loadClass(className);
        System.out.println(clazz2.getName());
    }
    @Test
    public void test1() throws IllegalAccessException, InstantiationException, NoSuchFieldException, NoSuchMethodException, InvocationTargetException {
        Class clazz = Person.class;
        Person p = (Person) clazz.newInstance();

        System.out.println(p);

//        Field f1 = clazz.getField("name");
        Field f2 = clazz.getDeclaredField("name");
        f2.setAccessible(true);
        f2.set(p, "xixi");

        System.out.println(p);

        Method m1 = clazz.getDeclaredMethod("show");
        m1.invoke(p);

        Method m2 = clazz.getDeclaredMethod("display", String.class);
        m2.invoke(p, "cn");
    }
}

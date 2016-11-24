package com.bruce.guava_learning.reflection_demo;

import org.junit.Test;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/**
 * Created by wuteng1 on 2016/9/17.
 */
interface China{
    public static final String name = "Rollen";
    public static int age = 20;
    public void sayChina();
    public void sayHello(String name, int age);
}

class Person implements China{

    private String sex;

    public Person(){

    }

    public Person(String sex){
        this.sex = sex;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public void sayChina() {
        System.out.println("hello, China");
    }

    public void sayHello(String name, int age) {
        System.out.println(name + " " + age);
    }


}


public class MethodReflectionHelloWorld {
    @Test
    public void testInterface(){
        Class<?> demo = null;
        try {
            demo = Class.forName("com.bruce.guava_learning.reflection_demo.Person");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        Class<?> intes[] = demo.getInterfaces();
        for(int i = 0; i < intes.length; i++){
            System.out.println("interface implemented " + intes[i].getName());
        }
    }

    @Test
    public void testMethod(){
        Class<?> demo = null;
        try {
            demo = Class.forName("com.bruce.guava_learning.reflection_demo.Person");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        Method[] method = demo.getMethods();
        for(int i = 0; i < method.length; i++){
            Class<?> returnType = method[i].getReturnType();
            Class<?> para[] = method[i].getParameterTypes();
            int temp = method[i].getModifiers();
            System.out.print(Modifier.toString(temp) + " ");
            System.out.print(returnType.getName() + " ");
            System.out.print(method[i].getName() + " ");
            System.out.print("(");
            for(int j = 0; j < para.length; ++j){
                System.out.print(para[j].getName() + " arg" + j);
                if(j < para.length-1)
                    System.out.print(",");
            }

            Class<?> exec[] = method[i].getExceptionTypes();
            if(exec.length > 0){
                System.out.print(") throws ");
                for(int k = 0; k < exec.length; k++){
                    System.out.print(exec[k].getName() + " ");
                    if(k < exec.length-1)
                        System.out.print(",");
                }
            }
            else{
                System.out.print(")");
            }
            System.out.println();
        }

    }
}

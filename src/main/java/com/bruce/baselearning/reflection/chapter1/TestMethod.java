package com.bruce.baselearning.reflection.chapter1;

import org.junit.Test;

import java.lang.reflect.Method;

/**
 * Created by wuteng1 on 2016/8/13.
 */
public class TestMethod {
    @Test
    public void test1(){
        Class clazz = StrongPerson.class;
        Method[] methods = clazz.getMethods();
        for(Method m: methods){
            System.out.println(m);
        }
        System.out.println("*******************");

        Method[] declaredMethods = clazz.getDeclaredMethods();
        for(Method m: declaredMethods){
            System.out.println(m);
            Class<?> returnType = m.getReturnType();
            System.out.println(returnType.getName());
            Class<?>[] parameterTypes = m.getParameterTypes();
            for(int i = 0; i < parameterTypes.length; i++){
                System.out.println("args index-" + i + " " + parameterTypes[i].getName());
            }
        }
    }
}

package com.bruce.design_pattern.chapter11;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by wuteng1 on 2016/8/1.
 */
public class OwnerInvocationHandler implements InvocationHandler {

    PersonBean person;

    public OwnerInvocationHandler(PersonBean person) {
        this.person = person;
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws InvocationTargetException, IllegalAccessException {
        if(method.getName().startsWith("get")){
            return method.invoke(person, args);
        }
        else if(method.getName().equals("setHotOrNotRating")){
            return new IllegalAccessException();
        }
        else if (method.getName().startsWith("set")) {

            return method.invoke(person, args);
        }
        return null;
    }
}

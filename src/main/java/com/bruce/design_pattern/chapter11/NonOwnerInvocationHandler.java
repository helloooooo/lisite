package com.bruce.design_pattern.chapter11;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Created by wuteng1 on 2016/8/1.
 */
public class NonOwnerInvocationHandler implements InvocationHandler {

    PersonBean personBean;

    public NonOwnerInvocationHandler(PersonBean personBean) {
        this.personBean = personBean;
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if(method.getName().equals("setHotOrNotRating")){
            return method.invoke(personBean, args);
        }
        else if(method.getName().startsWith("get")){
            return method.invoke(personBean, args);
        }
        else if(method.getName().startsWith("set")){
            return new IllegalAccessException();
        }
        return null;
    }
}

package com.bruce.design_pattern.chapter11;

import com.bruce.clonedemo.demo1.Person;

import java.lang.reflect.Proxy;

/**
 * Created by wuteng1 on 2016/8/1.
 */
public class MatchingMakingTestDriver {
    public static void main(String[] args) {
        MatchingMakingTestDriver matchingMakingTestDriver = new MatchingMakingTestDriver();
        matchingMakingTestDriver.drive();
    }
    public void drive(){
        PersonBean p1 = new PersonBeanImpl();
        PersonBean ownProxy = getOwnProxy(p1);
        try {
            ownProxy.setHotOrNotRating(1);
        } catch (Throwable e) {
            System.out.println("xiix");
            System.out.println(e);
        }
        ownProxy.setName("bruce");
        System.out.println(ownProxy.getName());
        System.out.println(ownProxy.getHotOrNotRating());
        System.out.println("-----------------");
        PersonBean nonOwnProxy = getNonOwnProxy(p1);
        nonOwnProxy.setHotOrNotRating(2);
        try {
            nonOwnProxy.setName("xixi");
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(nonOwnProxy.getName());
        System.out.println(nonOwnProxy.getHotOrNotRating());
        System.out.println("-------------");
    }

    PersonBean getOwnProxy(PersonBean personBean){
        return (PersonBean) Proxy.newProxyInstance(personBean.getClass().getClassLoader(), personBean.getClass().getInterfaces()
        ,new OwnerInvocationHandler(personBean));
    }

    PersonBean getNonOwnProxy(PersonBean personBean){
        return (PersonBean) Proxy.newProxyInstance(personBean.getClass().getClassLoader(),
                personBean.getClass().getInterfaces(),
                new NonOwnerInvocationHandler(personBean));
    }
}

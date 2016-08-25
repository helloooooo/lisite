package com.bruce.design_pattern.chapter7;

/**
 * Created by wuteng1 on 2016/8/1.
 */
public class Tea extends CaffeineBeverage {
    @Override
    protected void addCondiments() {
        System.out.println("adding lemon");
    }

    @Override
    protected void brew() {
        System.out.println("steeping the tea");
    }
}

package com.bruce.design_pattern.chapter7;

/**
 * Created by wuteng1 on 2016/8/1.
 */
public class Coffee extends CaffeineBeverage {
    @Override
    protected void addCondiments() {
        System.out.println("adding milk and sugar");
    }

    @Override
    protected void brew() {
        System.out.println("driping coffee");
    }
}

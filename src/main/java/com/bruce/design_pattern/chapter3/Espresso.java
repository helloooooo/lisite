package com.bruce.design_pattern.chapter3;

/**
 * Created by wuteng1 on 2016/7/30.
 */
public class Espresso extends Beverage {
    public Espresso() {
        description = "Espresso";
    }

    @Override
    public double cost() {
        return 1.99;
    }
}

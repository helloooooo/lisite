package com.bruce.design_pattern.chapter3;

/**
 * Created by wuteng1 on 2016/7/30.
 */
public class HouseBlend extends Beverage {

    public HouseBlend() {
        description = "HouseBlend";
    }

    @Override
    public double cost() {
        return .88;
    }
}

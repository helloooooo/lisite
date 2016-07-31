package com.bruce.design_pattern.chapter3;

/**
 * Created by wuteng1 on 2016/7/30.
 */
public class Mocha extends CoordinateDecorator {

    Beverage beverage;

    public Mocha(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + " Mocha";
    }

    @Override
    public double cost() {
        return beverage.cost() + .99;
    }
}

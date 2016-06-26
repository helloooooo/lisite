package com.bruce.designpattern.decorator;

/**
 * Created by wuteng1 on 2016/6/8.
 */
public class Whip extends CondimentDecorator{
    Beverage beverage;
    public Whip(Beverage beverage){
        this.beverage = beverage;
    }
    @Override
    public String getDescription() {
        return beverage.getDescription() + ", whip";
    }

    @Override
    public double cost() {
        return .12 + beverage.cost();
    }
}

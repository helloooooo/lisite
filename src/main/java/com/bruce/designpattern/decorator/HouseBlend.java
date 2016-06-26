package com.bruce.designpattern.decorator;

/**
 * Created by wuteng1 on 2016/6/8.
 */
public class HouseBlend extends Beverage{
    public HouseBlend(){
        description = "House Blend Coffee";
    }
    @Override
    public double cost() {
        return .89;
    }
}

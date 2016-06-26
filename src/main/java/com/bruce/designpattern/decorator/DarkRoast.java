package com.bruce.designpattern.decorator;

/**
 * Created by wuteng1 on 2016/6/8.
 */
public class DarkRoast extends Beverage{
    public DarkRoast(){
        description = "DarkRoast";
    }
    @Override
    public double cost() {
        return .99;
    }
}

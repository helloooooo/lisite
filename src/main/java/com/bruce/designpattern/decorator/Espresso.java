package com.bruce.designpattern.decorator;

/**
 * Created by wuteng1 on 2016/6/8.
 */
public class Espresso extends Beverage{

    public Espresso(){
        description = "Espresso";
    }
    @Override
    public double cost() {
        return 1.99;
    }
}

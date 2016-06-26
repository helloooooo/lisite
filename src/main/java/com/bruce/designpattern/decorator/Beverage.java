package com.bruce.designpattern.decorator;

/**
 * Created by wuteng1 on 2016/6/8.
 */
public abstract class Beverage {
    String description = "Unknown Beverage";
    public String getDescription(){
        return description;
    }
    public abstract double cost();
}

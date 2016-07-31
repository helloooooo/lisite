package com.bruce.design_pattern.chapter3;

/**
 * Created by wuteng1 on 2016/7/30.
 */
public abstract class Beverage {
    String description = "Unknown Beverage";
    public String getDescription(){
        return description;
    }

    public abstract double cost();
}

package com.bruce.design_pattern.chapter7;

/**
 * Created by wuteng1 on 2016/8/1.
 */
public abstract class CaffeineBeverage {
    final void prepareRecipe(){
        boilWater();
        brew();
        pourInCup();
        addCondiments();
    }

    protected abstract void addCondiments();

    protected abstract void brew();

    public void pourInCup(){
        System.out.println("Pouring into cup");
    }

    public void boilWater(){
        System.out.println("Boiling water");
    }



}

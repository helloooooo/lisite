package com.bruce.design_pattern.chapter4;

/**
 * Created by wuteng1 on 2016/7/31.
 */
public abstract class Pizza {

    String name;
    Dough dough;
    Sauce sauce;
    Veggies veggies;
    Cheese cheese;
    Pepperoni pepperoni;
    Clams clams;

    abstract void prepare();

    public void bake(){
        System.out.println("baking for 25 mins. ");
    }

    public void cut(){
        System.out.println("cuting into pieces. ");
    }

    public void box(){
        System.out.println("placing in boxes. ");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "this is my pizza " + getName();
    }
}

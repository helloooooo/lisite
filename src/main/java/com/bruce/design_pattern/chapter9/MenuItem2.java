package com.bruce.design_pattern.chapter9;

/**
 * Created by wuteng1 on 2016/8/1.
 */
public class MenuItem2 extends MenuComponent {
    String name;
    String description;
    boolean isVegetarian;
    double price;

    public MenuItem2(String name, String description, boolean isVegetarian, double price) {
        this.name = name;
        this.description = description;
        this.isVegetarian = isVegetarian;
        this.price = price;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public boolean isVegetarian() {
        return isVegetarian;
    }

    @Override
    public double getPrice() {
        return price;
    }

    public void print(){
        System.out.println(" " + getName());
        if(isVegetarian()){
            System.out.println("(v)");
        }

        System.out.println(", " + getPrice());
        System.out.println("," + getDescription());
    }
}

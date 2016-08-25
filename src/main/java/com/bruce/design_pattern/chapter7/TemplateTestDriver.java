package com.bruce.design_pattern.chapter7;

/**
 * Created by wuteng1 on 2016/8/1.
 */
public class TemplateTestDriver {
    public static void main(String[] args) {
        System.out.println("------------producing a cup of tea--------------");
        Tea tea = new Tea();
        tea.prepareRecipe();
        System.out.println("------------preparing a cup of coffee-----------");
        Coffee coffee = new Coffee();
        coffee.prepareRecipe();

        System.out.println("--------------making coffee with hook-----------------");
        CoffeeWithHook coffeeWithHook = new CoffeeWithHook();
        coffeeWithHook.prepareReceipt();
    }
}

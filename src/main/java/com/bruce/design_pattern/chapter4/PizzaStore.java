package com.bruce.design_pattern.chapter4;

/**
 * Created by wuteng1 on 2016/7/31.
 */
public abstract class PizzaStore {

    public Pizza orderPizza(String item){
        Pizza pizza;

        pizza = createPizza(item);

        pizza.prepare();
        pizza.bake();
        pizza.cut();
        pizza.box();

        return pizza;
    }

    protected abstract Pizza createPizza(String item);
}

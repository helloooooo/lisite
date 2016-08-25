package com.bruce.design_pattern.chapter4;

/**
 * Created by wuteng1 on 2016/7/31.
 */
public interface PizzaIngredientFactory {

    public Dough createDough();

    public Sauce createSauce();

    public Cheese createCheese();

    public Veggies[] createVeggies();

    public Pepperoni createPepperoni();

    public Clams createClams();

}

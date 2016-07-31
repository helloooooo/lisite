package com.bruce.design_pattern.chapter1;

/**
 * Created by wuteng1 on 2016/7/28.
 */
public class MallardDuck extends Duck{
    public MallardDuck() {
        quackBehavior = new Quack();
        flyBehavior = new FlyingWithWings();
    }

    @Override
    public void display() {
        System.out.println("i am a mallard duck");
    }
}

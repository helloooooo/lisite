package com.bruce.design_pattern.chapter1;

/**
 * Created by wuteng1 on 2016/7/28.
 */
public class MiniDuckSimulator {
    public static void main(String[] args) {
        Duck duck = new MallardDuck();
        duck.performFly();
        duck.performQuack();
        duck.display();
    }
}

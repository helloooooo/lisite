package com.bruce.design_pattern.chapter6;

/**
 * Created by wuteng1 on 2016/8/1.
 */
public class DuckTestDrive {
    public static void main(String[] args) {
        MallardDuck mallardDuck = new MallardDuck();
        WildTurkey wildTurkey = new WildTurkey();

        Duck turkeyAdapter = new TurkeyAdapter(wildTurkey);
        mallardDuck.fly();
        mallardDuck.quack();

        wildTurkey.fly();
        wildTurkey.gobble();
        System.out.println("----------------------");

        testDuck(mallardDuck);
        testDuck(turkeyAdapter);
    }

    public static void testDuck(Duck duck){
        duck.fly();
        duck.quack();
    }
}

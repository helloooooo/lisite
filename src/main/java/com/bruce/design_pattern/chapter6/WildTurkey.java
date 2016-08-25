package com.bruce.design_pattern.chapter6;

/**
 * Created by wuteng1 on 2016/8/1.
 */
public class WildTurkey implements Turkey{
    public void gobble() {
        System.out.println("Gobble gobble");
    }

    public void fly() {
        System.out.println("I am flying a short distance");
    }
}

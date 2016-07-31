package com.bruce.design_pattern.chapter1;

/**
 * Created by wuteng1 on 2016/7/28.
 */
public class MuteQuack implements QuackBehavior{
    public void quack() {
        System.out.println("silent");
    }
}

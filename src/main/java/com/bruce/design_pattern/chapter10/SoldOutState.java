package com.bruce.design_pattern.chapter10;

/**
 * Created by wuteng1 on 2016/8/1.
 */
public class SoldOutState implements State {

    GumballMachine gumballMachine;

    public SoldOutState(GumballMachine gumballMachine) {
        this.gumballMachine = gumballMachine;
    }

    public void insertQuarter() {
        System.out.println("don't insert a quarter, because there is no ball");
    }

    public void ejectQuarter() {
        System.out.println("no return quarter. sorry");
    }

    public void turnCrack() {
        System.out.println("no ball inside");
    }

    public void dispense() {
        System.out.println("no ball inside");
    }
}

package com.bruce.design_pattern.chapter10;

/**
 * Created by wuteng1 on 2016/8/1.
 */
public class NoQuarterState implements State {

    GumballMachine gumballMachine;

    public NoQuarterState(GumballMachine gumballMachine) {
        this.gumballMachine = gumballMachine;
    }

    public void insertQuarter() {
        System.out.println("you insert a quarter");
        gumballMachine.setState(gumballMachine.hasQuarterState);
    }

    public void ejectQuarter() {
        System.out.println("you haven't inserted a quarter");
    }

    public void turnCrack() {
        System.out.println("you truned, but there is no quarter");
    }

    public void dispense(){
        System.out.println("you need pay first");
    }

}

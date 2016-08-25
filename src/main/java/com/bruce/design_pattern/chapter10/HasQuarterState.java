package com.bruce.design_pattern.chapter10;

/**
 * Created by wuteng1 on 2016/8/1.
 */
public class HasQuarterState implements State {

    GumballMachine gumballMachine;

    public HasQuarterState(GumballMachine gumballMachine) {
        this.gumballMachine = gumballMachine;
    }

    public void insertQuarter() {
        System.out.println("you have already insert a quarter");
    }

    public void ejectQuarter() {
        System.out.println("quarter returned");
        gumballMachine.setState(gumballMachine.noQuarterState);
    }

    public void turnCrack() {
        System.out.println("you turn crack");
        gumballMachine.setState(gumballMachine.soldState);
    }

    public void dispense() {
        System.out.println("no gumball dispensed");
    }
}

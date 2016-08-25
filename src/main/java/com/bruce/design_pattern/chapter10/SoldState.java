package com.bruce.design_pattern.chapter10;

/**
 * Created by wuteng1 on 2016/8/1.
 */
public class SoldState implements State {

    GumballMachine gumballMachine;

    public SoldState(GumballMachine gumballMachine) {
        this.gumballMachine = gumballMachine;
    }

    public void insertQuarter() {
        System.out.println("please wait, we have already give you a ball");
    }

    public void ejectQuarter() {
        System.out.println("you can't return a quarter");
    }

    public void turnCrack() {
        System.out.println("turning twice doestn't give you double ball");
    }

    public void dispense() {
        gumballMachine.releaseBall();
        if(gumballMachine.count > 0){
            gumballMachine.setState(gumballMachine.noQuarterState);
        }
        else{
            System.out.println("oops, out of gumball");
            gumballMachine.setState(gumballMachine.soldOutState);
        }
    }
}

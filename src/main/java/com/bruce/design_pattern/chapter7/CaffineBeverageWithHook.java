package com.bruce.design_pattern.chapter7;

/**
 * Created by wuteng1 on 2016/8/1.
 */
public abstract class CaffineBeverageWithHook {
    final void prepareReceipt(){
        boilWater();
        brew();
        pourInCup();
        if(customerWantsCondiments()){
            addCondiments();
        }
    }

    protected abstract void addCondiments();

    public boolean customerWantsCondiments() {
        return true;
    }

    private void pourInCup() {
        System.out.println("pouring water into cup");
    }

    protected abstract void brew();
    

    public void boilWater() {
        System.out.println("boiling water");
    }
}

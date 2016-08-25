package com.bruce.design_pattern.chapter7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by wuteng1 on 2016/8/1.
 */
public class CoffeeWithHook extends CaffineBeverageWithHook {
    @Override
    protected void addCondiments() {
        System.out.println("adding milk and sugar");
    }

    @Override
    protected void brew() {
        System.out.println("driling coffee");
    }

    @Override
    public boolean customerWantsCondiments() {
        String answer = getUserInput();
        if(answer.startsWith("y"))
            return true;
        else return false;
    }


    private String getUserInput() {
        String answer = null;
        System.out.println("would you like add milk and sugar into the coffee?");
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String s = null;
        try {
            s = bufferedReader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        if(s == null)
            return "no";
        return s;
    }
}

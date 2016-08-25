package com.bruce.design_pattern.chapter5;

/**
 * Created by wuteng1 on 2016/7/31.
 */
public class NoCommand implements Command {
    public void execute() {
        System.out.println("no command");
    }

    public void undo() {

    }
}

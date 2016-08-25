package com.bruce.design_pattern.chapter5;

/**
 * Created by wuteng1 on 2016/7/31.
 */
public class LightOffCommand implements Command{
    Light light;

    public LightOffCommand(Light light) {
        this.light = light;
    }

    public void execute() {
        light.off();
    }

    public void undo() {
        light.on();
    }
}

package com.bruce.design_pattern.chapter5;

/**
 * Created by wuteng1 on 2016/7/31.
 */
public class RemoteControllerTest {
    public static void main(String[] args) {
        SimpleRemoteControl remote = new SimpleRemoteControl();
        Light light = new Light();
        LightOnComand lightOnComand = new LightOnComand(light);
        remote.setCommand(lightOnComand);
        remote.buttonWasPressed();
    }
}

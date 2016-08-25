package com.bruce.design_pattern.chapter5;

/**
 * Created by wuteng1 on 2016/7/31.
 */
public class StereoOnWithCDCommand implements Command {

    Stereo stereo;

    public StereoOnWithCDCommand(Stereo stereo) {
        this.stereo = stereo;
    }

    public void execute() {
        stereo.on();
        stereo.setCd();
        stereo.setVolumn(11);
    }

    public void undo() {

    }
}

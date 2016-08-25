package com.bruce.design_pattern.chapter5;

/**
 * Created by wuteng1 on 2016/7/31.
 */
public class StereoOffWithCDCommand implements Command {
    Stereo stereo;

    public StereoOffWithCDCommand(Stereo stereo) {
        this.stereo = stereo;
    }

    public void execute() {
        stereo.off();
    }

    public void undo() {

    }
}

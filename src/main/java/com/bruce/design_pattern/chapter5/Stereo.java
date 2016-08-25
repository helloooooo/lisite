package com.bruce.design_pattern.chapter5;

/**
 * Created by wuteng1 on 2016/7/31.
 */
public class Stereo {
    public void on(){
        System.out.println("stereo on");
    }

    public void off(){
        System.out.println("stereo off");
    }

    public void setCd(){
        System.out.println("setting cd");
    }

    public void setDvd(){
        System.out.println("setting dvd");
    }

    public void setVolumn(int volumn){
        System.out.println("setting volumn at " + volumn);
    }
}


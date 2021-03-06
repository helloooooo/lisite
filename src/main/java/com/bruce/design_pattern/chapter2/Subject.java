package com.bruce.design_pattern.chapter2;

/**
 * Created by wuteng1 on 2016/7/29.
 */
public interface Subject {
    public void registerObserver(Observer o);
    public void removeObserver(Observer o);
    public void notifyObservers();

}

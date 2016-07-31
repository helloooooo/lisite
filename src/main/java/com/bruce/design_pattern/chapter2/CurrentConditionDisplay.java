package com.bruce.design_pattern.chapter2;

/**
 * Created by wuteng1 on 2016/7/30.
 */
public class CurrentConditionDisplay implements Observer, DisplayElement{
    private float humidity;
    private float temperature;
    private Subject subject;

    public CurrentConditionDisplay(Subject subject) {
        this.subject = subject;
        subject.registerObserver(this);
    }

    public void display() {
        System.out.println("current condition --> temperature: " + this.temperature + " humidity: " + this.humidity);
    }

    public void update(float temperature, float humidity, float pressure) {
        this.humidity = humidity;
        this.temperature = temperature;
        display();
    }
}

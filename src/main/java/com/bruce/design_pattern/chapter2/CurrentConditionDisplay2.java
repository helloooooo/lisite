package com.bruce.design_pattern.chapter2;


import java.util.*;
import java.util.Observer;

/**
 * Created by wuteng1 on 2016/7/30.
 */
public class CurrentConditionDisplay2 implements Observer, DisplayElement{
    private Observable observable;
    private float temperature;
    private float humidity;

    public CurrentConditionDisplay2(Observable observable) {
        this.observable = observable;
        this.observable.addObserver(this);
    }

    public void display() {
        System.out.println("current condition -> temperature: " + temperature + " humidity: " + humidity);
    }

    public void update(Observable o, Object arg) {
        if(o instanceof WeatherData2){
            WeatherData2 weatherData2 = (WeatherData2) o;
            this.temperature = weatherData2.getTemperature();
            this.humidity = weatherData2.getHumidity();
            display();
        }
    }
}

package com.bruce.design_pattern.chapter2;

/**
 * Created by wuteng1 on 2016/7/30.
 */
public class WeatherStation {
    public static void main(String[] args) {
        WeatherData weatherData = new WeatherData();
        CurrentConditionDisplay currentConditionDisplay = new CurrentConditionDisplay(weatherData);

        weatherData.setMeasurements(30f, 30f, 10f);
        weatherData.setMeasurements(30f, 32f, 21f);
    }
}

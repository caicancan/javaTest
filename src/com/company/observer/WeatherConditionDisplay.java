package com.company.observer;


public class WeatherConditionDisplay implements Observer,DisplayElement {
    private Subject weatherData;
    private float temp;
    private float humidity;
    private float pressure;
    public WeatherConditionDisplay(Subject weatherData) {
        this.weatherData=weatherData;
        //实际上有点类似添加接口
        weatherData.registerObserver(this::update);
    }

    @Override
    public void display() {
    System.out.println("temp"+temp+"humidity"+humidity+"pressure"+pressure);
    }

    @Override
    public void update(float temp, float humidity, float pressure) {
        this.temp=temp;
        this.humidity=humidity;
        this.pressure=pressure;
        display();
    }
}

package com.company.observer2;

import com.company.observer.DisplayElement;

import java.util.Observable;
import java.util.Observer;

public class CurrentConditionDisplay2 implements Observer, DisplayElement {
    private Observable observable;
    private float temp;
    private float humdity;
    private float pressure;

    //第一步在实现观察者的时候需要实例化并且添加注册观察者(将接口传进来进行注册)
    public CurrentConditionDisplay2(Observable observable) {
        this.observable = observable;
        observable.addObserver(this::update);
    }

    @Override
    public void display() {
    System.out.println("这是自带的observer"+temp+"__humidity"+humdity+"pressure"+pressure);
    }

    @Override
    public void update(Observable o, Object arg) {
        if (o instanceof WeatherData2) {
            this.temp = ((WeatherData2) o).getTemp();
            this.humdity = ((WeatherData2) o).getHumitidy();
            this.pressure = ((WeatherData2) o).getPressure();
            display();
        }
    }
}

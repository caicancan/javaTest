package com.company.observer2;

import java.util.Observable;
/**
 * 这里的不同点是自带的observable是一个类
 * */
public class WeatherData2 extends Observable {
    private float temp;
    private float humitidy;
    private float pressure;

    public WeatherData2(){

    }
    public void  setMeasureMents(float temp,float humitidy,float pressure){
        this.temp=temp;
        this.humitidy=humitidy;
        this.pressure=pressure;
        measureMentsChanged();
    }

    public float getTemp() {
        return temp;
    }

    public float getHumitidy() {
        return humitidy;
    }

    public float getPressure() {
        return pressure;
    }

    private void measureMentsChanged() {
        setChanged();
        notifyObservers();
    }
}

package com.company.observer;

import java.util.ArrayList;
import com.company.observer.Observer;

public class WeatherData implements Subject {

    private final ArrayList observers;
    private float temp;
    private float humitidy;
    private float pressure;
    private boolean changed;

    public WeatherData(){
        //模仿observable源码中对于被观察者的实现监察
       // setChanged();
        observers = new ArrayList();
    }
    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
        //observer实际上指的就是接口
    }

    @Override
    public void removeObserver(Observer observer) {
        int i = observers.indexOf(observer);
        if (i>=0){
            observers.remove(i);
        }
    }

    public void setChanged(){
        changed=true;
    }
    //由被观察者（对象）去通知观察者（调用接口）
    @Override
    public void notifyObservers() {
        if (changed) {
            for (int i = 0; i < observers.size(); i++) {
                Observer observer = (Observer) observers.get(i);
                observer.update(temp, humitidy, pressure);
            }
            changed=false;
        }
    }

    public void  setMeasureMents(float temp,float humitidy,float pressure){
        this.temp=temp;
        this.humitidy=humitidy;
        this.pressure=pressure;
        measureMentsChanged();
    }

    private void measureMentsChanged() {
        notifyObservers();
    }
}

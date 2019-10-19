package com.company.observer;
import com.company.observer.Observer;

public interface Subject {
    //数据实体类对于接口的操作，添加，移除和更新
public void registerObserver(Observer observer);
public void removeObserver(Observer observer);
public void notifyObservers();
}

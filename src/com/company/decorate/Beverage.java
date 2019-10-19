package com.company.decorate;

/**
 * 抽象组件
 * */
public abstract class Beverage {
    String description="Unknown Beverage";
    String size="middle";

    public String getDescription() {
        return description;
    }
    public String getSize(){
        return size;
    }
    public abstract double cost();

}

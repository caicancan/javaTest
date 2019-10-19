package com.company.decorate;

/**
 * 具体组件
 * */
public class HouseBlend extends Beverage {
    public HouseBlend(){
        description="House Blend Coffee";
        size="big";
    }
    @Override
    public double cost() {
        return 0.89;
    }
}

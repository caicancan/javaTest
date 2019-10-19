package com.company.decorate;

/**
 * 具体组件
 * */
public class Expresso extends Beverage {

    public Expresso(){
        description = "Expresso";
        size="middle";
    }
    @Override
    public double cost() {
        return 1.99;
    }
}

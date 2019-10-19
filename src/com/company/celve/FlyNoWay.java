package com.company.celve;

public class FlyNoWay implements FlyBehavior {
    @Override
    public void flay() {
        System.out.println("我不会飞");
    }
}

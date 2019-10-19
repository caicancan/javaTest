package com.company.celve;

public class FlyWithWings implements FlyBehavior {
    private static FlyWithWings[] aa=new FlyWithWings[10];
    @Override
    public void flay() {
        System.out.println("我会飞");
    }
}

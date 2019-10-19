package com.company.adapter_model;

public class MallardDuck implements Duck {
    @Override
    public void quack() {
        System.out.println("duck quack");
    }

    @Override
    public void fly() {
        System.out.println("I am flying");
    }
}

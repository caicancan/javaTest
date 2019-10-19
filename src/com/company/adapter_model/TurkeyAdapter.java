package com.company.adapter_model;

public class TurkeyAdapter implements Duck {
    Turkey turkey;
   //来包装Turkey使它拥有鸭子的特性
    public TurkeyAdapter(Turkey turkey) {
        this.turkey=turkey;
    }

    @Override
    public void quack() {
        turkey.gobble();
    }

    @Override
    public void fly() {
        for (int i = 0; i < 5; i++) {
            turkey.fly();
        }
    }
}

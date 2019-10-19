package com.company.adapter_model;

public class WildTurkey implements Turkey{
    @Override
    public void gobble() {
        System.out.println("我是Gobble,gooble");
    }

    @Override
    public void fly() {
        System.out.println("我飞一小段距离");
    }
}

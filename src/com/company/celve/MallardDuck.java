package com.company.celve;

public class MallardDuck extends Duck {

    public MallardDuck(){
        //面对接口编程
        quackBehavior=new Quack();
        flyBehavior=new FlyWithWings();


    }
    @Override
    public void display() {
        System.out.println("我是一只真正的mallardDuck");
    }
}

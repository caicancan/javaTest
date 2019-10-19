package com.company.celve;

public abstract class Duck {
FlyBehavior flyBehavior;
QuackBehavior quackBehavior;
public Duck(){

}
public abstract void display();

/**
 * 委托给行为类
 * */
public void performFly(){
    flyBehavior.flay();
}
public  void performQuack(){
    quackBehavior.quack();
}

public void swim(){
    System.out.println("所有的鸭子都会游泳");
}
}

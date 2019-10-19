package com.company.factory;

public class ChiagoCheesePizza extends Pizza {


  public ChiagoCheesePizza(){
      name="ChiagoCheesePizza";
      toppings.add("create ChiagoCheesePizza");
  }

    //覆盖了cut的方法
    void cut(){
        System.out.println("这ChiagoCheesePizza要切成正方形");
    }
}

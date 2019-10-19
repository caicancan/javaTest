package com.company.factory;

import java.util.ArrayList;

public abstract class Pizza {

    String name;
    String dough;
    String sauce;
    ArrayList toppings=new ArrayList();
    //所有的子类必须经过的工序
   void prepare(){
       System.out.println("prepare"+name);
       for (int i = 0; i < toppings.size(); i++) {
           System.out.println(""+toppings.get(i));
       }
   }
   void bake(){
       System.out.println("bake");
   }
   void cut(){
       System.out.println("cut");
   }
   void box(){
       System.out.println("box");
   }

    public String getName() {
        return name;
    }
}

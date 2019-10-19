package com.company.celve;

public class MuteQuack implements QuackBehavior {
    @Override
    public void quack() {
        System.out.println("mutequack");
    }
}

package com.company.factory;

public class NYPizzaStore extends PizzaStore {

    @Override
    protected Pizza createPizza(String type) {
        NYStyleCheesePizza nYStyleCheesePizza = new NYStyleCheesePizza();
        return  nYStyleCheesePizza;
    }
}

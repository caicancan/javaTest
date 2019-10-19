package com.company.factory;

public  class ChiagoPizzaStore extends PizzaStore {

    @Override
    protected Pizza createPizza(String type) {
        return new ChiagoCheesePizza();
    }
}

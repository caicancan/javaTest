package com.company.decorate;

/**
 * 装饰者
 * */
public class Mocha extends CondimentDecorator {

    private Beverage beverage;
    public Mocha(Beverage beverage){
        this.beverage=beverage;
    }
    @Override
    public String getDescription() {
        return beverage.getDescription()+beverage.getSize()+"，Mocha";
    }

    @Override
    public String getSize() {
        return beverage.getSize();
    }

    @Override
    public double cost() {
        //在这可以再加入另一个修饰大小来进行数据的增减运算
        if (getSize().equals("middle")){

        }
        return 0.20+beverage.cost();
    }
}

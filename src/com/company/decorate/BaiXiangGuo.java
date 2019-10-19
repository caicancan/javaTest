package com.company.decorate;

public class BaiXiangGuo extends CondimentDecorator {
    private Beverage beverage;
    //将基本组件传入
    public BaiXiangGuo(Beverage beverage){
        this.beverage=beverage;
    }
    @Override
    public String getDescription() {
        return beverage.getDescription()+beverage.getSize()+", BaiXiangGuo";
    }

    @Override
    public String getSize() {
        return beverage.getSize();
    }

    @Override
    public double cost() {
        return 0.20+beverage.cost();
    }
}

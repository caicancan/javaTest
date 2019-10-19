package com.company.decorate;

/**
 *调料的抽象类
 * 修饰组件
 * */
public abstract class CondimentDecorator extends Beverage {
 //子类重载方法
    public abstract String getDescription();
    public abstract String getSize();
}

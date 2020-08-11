package com.yangshm.designpattern.demo03.beverage;

public class Coffee01 extends Beverage {

    public Coffee01() {
        super.setDescription("Coffee01");
    }

    @Override
    public double cost() {
        return 1;
    }
}

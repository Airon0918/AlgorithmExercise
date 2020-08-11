package com.yangshm.designpattern.demo03.beverage;

public class Coffee02 extends Beverage {

    public Coffee02() {
        super.setDescription("Coffee02");
    }

    @Override
    public double cost() {
        return 2;
    }
}

package com.yangshm.designpattern.demo03.condiment;

import com.yangshm.designpattern.demo03.beverage.Beverage;
import lombok.Data;

@Data
public class Condiment02 extends Condiment {

    private Beverage beverage;

    public Condiment02(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + ", Condiment02";
    }

    @Override
    public double cost() {
        return beverage.cost() + 0.6;
    }
}

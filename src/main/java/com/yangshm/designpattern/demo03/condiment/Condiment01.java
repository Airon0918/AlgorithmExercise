package com.yangshm.designpattern.demo03.condiment;

import com.yangshm.designpattern.demo03.beverage.Beverage;
import lombok.Data;

@Data
public class Condiment01 extends Condiment {

    private Beverage beverage;

    public Condiment01(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + ", Condiment01";
    }

    @Override
    public double cost() {
        return beverage.cost() + 0.5;
    }
}

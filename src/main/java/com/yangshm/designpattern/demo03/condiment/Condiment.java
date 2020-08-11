package com.yangshm.designpattern.demo03.condiment;

import com.yangshm.designpattern.demo03.beverage.Beverage;

public abstract class Condiment extends Beverage {

    @Override
    public abstract String getDescription();

}

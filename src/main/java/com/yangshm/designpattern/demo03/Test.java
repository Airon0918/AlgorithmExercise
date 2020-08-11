package com.yangshm.designpattern.demo03;

import com.yangshm.designpattern.demo03.beverage.Beverage;
import com.yangshm.designpattern.demo03.beverage.Coffee01;
import com.yangshm.designpattern.demo03.condiment.Condiment01;
import com.yangshm.designpattern.demo03.condiment.Condiment02;

public class Test {
    public static void main(String[] args) {
        Beverage coffee01 = new Coffee01();
        System.out.println(coffee01.getDescription() + "   $" + coffee01.cost());
        coffee01 = new Condiment01(coffee01);
        coffee01 = new Condiment02(coffee01);
        coffee01 = new Condiment02(coffee01);
        System.out.println(coffee01.getDescription() + "   $" + coffee01.cost());
    }
}

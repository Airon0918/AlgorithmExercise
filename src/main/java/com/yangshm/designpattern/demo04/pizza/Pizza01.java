package com.yangshm.designpattern.demo04.pizza;

import com.yangshm.designpattern.demo04.factory.PizzaIngredientFactory;

public class Pizza01 extends Pizza {

    PizzaIngredientFactory factory;

    public Pizza01(PizzaIngredientFactory factory) {
        this.factory = factory;
    }

    @Override
    public void prepare() {
        this.setCheese(factory.createCheese());
        this.setDough(factory.createDough());
        this.setSauce(factory.createSauce());
    }
}

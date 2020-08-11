package com.yangshm.designpattern.demo04.pizza;

import com.yangshm.designpattern.demo04.factory.PizzaIngredientFactory;

public class Pizza02 extends Pizza {

    PizzaIngredientFactory factory;

    public Pizza02(PizzaIngredientFactory factory) {
        this.factory = factory;
    }

    @Override
    public void prepare() {
        this.setCheese(factory.createCheese());
        this.setDough(factory.createDough());
        this.setSauce(factory.createSauce());
    }
}

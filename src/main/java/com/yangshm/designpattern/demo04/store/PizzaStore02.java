package com.yangshm.designpattern.demo04.store;

import com.yangshm.designpattern.demo04.factory.Factory02;
import com.yangshm.designpattern.demo04.factory.PizzaIngredientFactory;
import com.yangshm.designpattern.demo04.pizza.Pizza;
import com.yangshm.designpattern.demo04.pizza.Pizza01;

public class PizzaStore02 extends PizzaStore {

    @Override
    protected Pizza createPizza(String type) {
        Pizza pizza = null;
        PizzaIngredientFactory factory = new Factory02();
        switch (type) {
            case "0201":
                pizza = new Pizza01(factory);
                pizza.setName("2号工厂1号披萨");
                break;
            case "0202":
                pizza = new Pizza01(factory);
                pizza.setName("2号工厂2号披萨");
                break;
            default:
                break;
        }

        return pizza;
    }
}

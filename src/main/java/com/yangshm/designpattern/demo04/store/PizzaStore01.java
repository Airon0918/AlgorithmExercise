package com.yangshm.designpattern.demo04.store;

import com.yangshm.designpattern.demo04.factory.Factory01;
import com.yangshm.designpattern.demo04.factory.PizzaIngredientFactory;
import com.yangshm.designpattern.demo04.pizza.Pizza;
import com.yangshm.designpattern.demo04.pizza.Pizza01;

public class PizzaStore01 extends PizzaStore {

    @Override
    protected Pizza createPizza(String type) {
        Pizza pizza = null;
        PizzaIngredientFactory factory = new Factory01();
        switch (type) {
            case "0101":
                pizza = new Pizza01(factory);
                pizza.setName("1号工厂1号披萨");
                break;
            case "0102":
                pizza = new Pizza01(factory);
                pizza.setName("1号工厂2号披萨");
                break;
            default:
                break;
        }

        return pizza;
    }
}

package com.yangshm.designpattern.demo04.factory;

import com.yangshm.designpattern.demo04.ingredient.*;

public class Factory01 implements PizzaIngredientFactory {
    @Override
    public Cheese createCheese() {
        Cheese cheese = new Cheese01();
        cheese.prepare();
        return cheese;
    }

    @Override
    public Dough createDough() {
        Dough dough = new Dough01();
        dough.prepare();
        return dough;
    }

    @Override
    public Sauce createSauce() {
        Sauce sauce  = new Sauce01();
        sauce.prepare();
        return sauce;
    }
}

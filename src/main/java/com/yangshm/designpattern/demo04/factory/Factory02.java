package com.yangshm.designpattern.demo04.factory;

import com.yangshm.designpattern.demo04.ingredient.*;

public class Factory02 implements PizzaIngredientFactory {
    @Override
    public Cheese createCheese() {
        Cheese cheese = new Cheese02();
        cheese.prepare();
        return cheese;
    }

    @Override
    public Dough createDough() {
        Dough dough = new Dough02();
        dough.prepare();
        return dough;
    }

    @Override
    public Sauce createSauce() {
        Sauce sauce = new Sauce02();
        sauce.prepare();
        return sauce;
    }
}

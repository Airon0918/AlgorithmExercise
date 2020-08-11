package com.yangshm.designpattern.demo04.factory;

import com.yangshm.designpattern.demo04.ingredient.Cheese;
import com.yangshm.designpattern.demo04.ingredient.Dough;
import com.yangshm.designpattern.demo04.ingredient.Sauce;

public interface PizzaIngredientFactory {

    Cheese createCheese();

    Dough createDough();

    Sauce createSauce();

}

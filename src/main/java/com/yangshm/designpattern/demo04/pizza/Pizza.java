package com.yangshm.designpattern.demo04.pizza;

import com.yangshm.designpattern.demo04.ingredient.Cheese;
import com.yangshm.designpattern.demo04.ingredient.Dough;
import com.yangshm.designpattern.demo04.ingredient.Sauce;
import lombok.Data;

@Data
public abstract class Pizza {

    private String name;
    private Cheese cheese;
    private Dough dough;
    private Sauce sauce;

    public abstract void prepare();

    public void bake() {
        System.out.println("Bake for 20minutes...");
    }

    public void cut() {
        System.out.println("Cutting the pizza into diagonal slices...");
    }

    public void box() {
        System.out.println("Place pizza in official PizzaStore box...");
    }
}

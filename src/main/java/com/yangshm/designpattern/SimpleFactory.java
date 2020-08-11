package com.yangshm.designpattern;

public class SimpleFactory {


}

class OrderPizza {
    Factory factory;

    public OrderPizza() {

    }

    public void setFactory(Factory factory) {
        this.factory = factory;
    }

    public Pizza oder(String orderType) {
        return factory.createPizza(orderType);
    }

}

class Factory {
    public Pizza createPizza(String orderType) {
        Pizza pizza = null;

        switch (orderType) {
            case "cheese":
                pizza = new CheesePizza();
                break;
            case "pepper":
                pizza = new PepperPizza();
                break;
            default:
                break;
        }

        return pizza;
    }
}

abstract class Pizza {
    protected String name;

    public abstract void prepare();

    public void bake() {

    }
}

class CheesePizza extends Pizza {

    @Override
    public void prepare() {

    }
}

class PepperPizza extends Pizza {

    @Override
    public void prepare() {

    }
}


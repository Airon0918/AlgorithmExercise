package com.yangshm.designpattern.demo04;

import com.yangshm.designpattern.demo04.store.PizzaStore;
import com.yangshm.designpattern.demo04.store.PizzaStore01;

public class Test {
    public static void main(String[] args) {
        PizzaStore store = new PizzaStore01();
        System.out.println(store.orderPizza("0101"));
    }
}

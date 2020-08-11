package com.yangshm.designpattern.demo01;

import com.yangshm.designpattern.demo01.duck.Duck;
import com.yangshm.designpattern.demo01.duck.Duck01;

public class Test {
    public static void main(String[] args) {
        Duck duck = new Duck01();
        duck.setName("JOJO");
        duck.performFly();
        duck.performQuack();
    }
}

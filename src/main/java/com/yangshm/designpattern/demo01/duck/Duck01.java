package com.yangshm.designpattern.demo01.duck;

import com.yangshm.designpattern.demo01.behavior.FlyWIthWings;
import com.yangshm.designpattern.demo01.behavior.QuackBehavior;
import com.yangshm.designpattern.demo01.behavior.QucakQuack;

public class Duck01 extends Duck {

    public Duck01() {
        setFlyBehavior(new FlyWIthWings());
        setQuackBehavior(new QucakQuack());
    }

    public Duck01(FlyWIthWings flyWIthWings, QuackBehavior quackBehavior) {
        setFlyBehavior(flyWIthWings);
        setQuackBehavior(quackBehavior);
    }

    @Override
    public void display() {
        System.out.println("一只" + getName());
    }
}

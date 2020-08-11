package com.yangshm.designpattern.demo01.duck;

import com.yangshm.designpattern.demo01.behavior.*;

public class Duck02 extends Duck {

    public Duck02() {
        setFlyBehavior(new FlyNoWay());
        setQuackBehavior(new QuackNoWay());
    }

    public Duck02(FlyWIthWings flyWIthWings, QuackBehavior quackBehavior) {
        setFlyBehavior(flyWIthWings);
        setQuackBehavior(quackBehavior);
    }

    @Override
    public void display() {
        System.out.println("一只" + getName());
    }
}

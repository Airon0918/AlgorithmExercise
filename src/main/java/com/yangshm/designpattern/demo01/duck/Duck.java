package com.yangshm.designpattern.demo01.duck;

import com.yangshm.designpattern.demo01.behavior.FlyBehavior;
import com.yangshm.designpattern.demo01.behavior.QuackBehavior;
import lombok.Data;

@Data
public abstract class Duck {
    private String name;
    private FlyBehavior flyBehavior;
    private QuackBehavior quackBehavior;

    public Duck() {
    }

    public Duck(String name, FlyBehavior flyBehavior, QuackBehavior quackBehavior) {
        this.name = name;
        this.flyBehavior = flyBehavior;
        this.quackBehavior = quackBehavior;
    }

    public abstract void display();


    public void performFly() {
        flyBehavior.fly();
    }

    public void performQuack() {
        quackBehavior.quack();
    }

    public void swim() {
        System.out.println("所有的鸭子都是在水上游");
    }
}

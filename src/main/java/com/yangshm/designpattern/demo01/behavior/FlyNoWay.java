package com.yangshm.designpattern.demo01.behavior;

public class FlyNoWay implements FlyBehavior {
    @Override
    public void fly() {
        System.out.println("不会飞");
    }
}

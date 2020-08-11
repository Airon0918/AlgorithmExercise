package com.yangshm.designpattern.demo01.behavior;

public class FlyWIthWings implements FlyBehavior {
    @Override
    public void fly() {
        System.out.println("使用翅膀飞");
    }
}

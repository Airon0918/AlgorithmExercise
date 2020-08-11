package com.yangshm.designpattern.demo01.behavior;

public class QucakQuack implements QuackBehavior {
    @Override
    public void quack() {
        System.out.println("呱呱叫");
    }
}

package com.yangshm.designpattern.demo06;

public class Turkey01 implements Turkey {
    @Override
    public void goobble() {
        System.out.println("火鸡叫...");
    }

    @Override
    public void fly() {
        System.out.println("火鸡飞...");
    }
}

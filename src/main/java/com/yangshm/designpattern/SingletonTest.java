package com.yangshm.designpattern;

public class SingletonTest {


}

//饿汉式
//Runtime类
class Singleton {
    private final static Singleton instance = new Singleton();
//    static {
//        instance = new Singleton();
//    }
    private Singleton() {
    }

    public static Singleton getInstance() {
        return instance;
    }
}

//双重检查
class Singleton01 {
    private static volatile Singleton01 instance;

    private Singleton01() {
    }

    public static Singleton01 getInstance() {
        if (instance == null) {
            synchronized (Singleton01.class) {
                if (instance == null) {
                    instance = new Singleton01();
                }
            }
        }
        return instance;
    }
}

//静态内部类
class Singleton02 {
    private static volatile Singleton01 instance;

    private Singleton02() {
    }

    private static class SingletonInstance {
        private static final Singleton02 INSTANCE = new Singleton02();
    }

    public static Singleton02 getInstance() {
        return SingletonInstance.INSTANCE;
    }
}

//枚举
enum Singleton03 {
    INSTANCE;

    public void say() {
        System.out.println();
    }
}








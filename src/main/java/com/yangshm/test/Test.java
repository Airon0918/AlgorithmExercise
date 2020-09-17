package com.yangshm.test;

import org.openjdk.jol.info.ClassLayout;

public class Test {
    public static void main(String[] args) throws InterruptedException {
        //JVM默认4秒后启用偏向锁，偏向第一个使用的线程
//        Thread.sleep(5000);
        Object object1 = new Object();
        System.out.println(Thread.currentThread().getName() + ":" + ClassLayout.parseInstance(object1).toPrintable());

        synchronized (object1) {
            System.out.println(Thread.currentThread().getName() + ":" + ClassLayout.parseInstance(object1).toPrintable());
        }

        new Thread(() -> {
            synchronized (object1) {
                System.out.println(Thread.currentThread().getName() + ":" + ClassLayout.parseInstance(object1).toPrintable());
            }
        }).start();
        Thread.sleep(4000);
        System.out.println(Thread.currentThread().getName() + ":" + ClassLayout.parseInstance(object1).toPrintable());

        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                synchronized (object1) {
                    System.out.println(ClassLayout.parseInstance(object1).toPrintable());
                }
            }).start();
        }

        Object object2 = new Object();
        System.out.println(ClassLayout.parseInstance(object2).toPrintable());

    }
}

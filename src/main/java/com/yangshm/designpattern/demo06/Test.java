package com.yangshm.designpattern.demo06;

import java.util.Random;
import java.util.concurrent.*;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Test {
    static class Task implements Callable<Integer> {
        //Executor
//ExecutorService
//AbstractExecutorService
//ThreadPoolExecutor
        @Override
        public Integer call() throws Exception {
            int sleepSeconds = new Random().nextInt(1000);
            Thread.sleep(sleepSeconds);
            return sleepSeconds;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Turkey turkey = new Turkey01();
        TurkeyAdapter turkeyAdapter = new TurkeyAdapter(turkey);
        turkeyAdapter.quack();
        turkeyAdapter.fly();

//
//        ExecutorService executor = Executors.newSingleThreadExecutor();
//        Future<Integer> future = executor.submit(new Task());
//        try {
//            System.out.println(future.get());
//        } catch (ExecutionException e) {
//
//        }
//        executor.shutdown();
//        ReentrantReadWriteLock a = new ReentrantReadWriteLock();


    }
}




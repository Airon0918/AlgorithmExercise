package com.yangshm.zookeeper;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.recipes.locks.InterProcessMutex;
import org.apache.curator.retry.ExponentialBackoffRetry;

import java.util.concurrent.TimeUnit;

public class TheadMutex {
    private static Integer count = 100;

    public static void main(String[] args) {

        CuratorFramework client = CuratorFrameworkFactory.builder()
                .connectString("127.0.0.1:2181")
                .sessionTimeoutMs(5000)
                .connectionTimeoutMs(3000)
                .retryPolicy(new ExponentialBackoffRetry(1000, 3)).build();


        client.start();
        InterProcessMutex interProcessMutex = new InterProcessMutex(client, "/lockpath");

        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                try {
                    if (interProcessMutex.acquire(10, TimeUnit.SECONDS)) {
                        System.out.println(count--);
                    }
                    Thread.sleep(100);
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    try {
                        if (interProcessMutex.isOwnedByCurrentThread()) {
                            interProcessMutex.release();
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }
    }

    private static class ImitateLock extends Thread {
        @Override
        public void run() {

            try {
//                client.create().withMode(CreateMode.CONTAINER).forPath("/lockpath");
//                client.delete().forPath("/lockpath");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}

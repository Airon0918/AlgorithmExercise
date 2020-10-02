package com.yangshm.zookeeper;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.data.Stat;
import org.junit.Test;

public class ZkWatcherDemo {
    private String testPath = "/test";

    private static CuratorFramework client = CuratorFrameworkFactory.builder()
            .connectString("127.0.0.1:2181")
            .sessionTimeoutMs(5000)
            .connectionTimeoutMs(3000)
            .retryPolicy(new ExponentialBackoffRetry(1000, 3)).build();

    @Test
    public void testWatcher() throws Exception {
        client.start();

        Stat stat = client.checkExists().forPath(testPath);
        if (stat == null) {
            client.create().forPath(testPath);
        }

        Watcher warcher = (WatchedEvent watchedEvent) -> {
            System.out.println("监听事件【WatchedEvent】：" + watchedEvent);
        };

        byte[] content = client.getData().usingWatcher(warcher).forPath(testPath);
        System.out.println("【数据变更】第一次");
        client.setData().forPath(testPath, "first".getBytes());
        System.out.println("【数据变更】第二次");
        client.setData().forPath(testPath, "second".getBytes());
    }

}

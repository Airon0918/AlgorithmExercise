package com.yangshm.zookeeper;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.recipes.cache.ChildData;
import org.apache.curator.framework.recipes.cache.NodeCache;
import org.apache.curator.framework.recipes.cache.NodeCacheListener;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.junit.Test;

public class NodeCacheDemo {
    private static CuratorFramework client = CuratorFrameworkFactory.builder()
            .connectString("127.0.0.1:2181")
            .sessionTimeoutMs(5000)
            .connectionTimeoutMs(3000)
            .retryPolicy(new ExponentialBackoffRetry(1000, 3)).build();

    @Test
    public void test() throws Exception {
        NodeCache nodeCache = new NodeCache(client, "/test");

        NodeCacheListener listener = () -> {
            ChildData childData = nodeCache.getCurrentData();
            System.out.println("事件监听Path：" + childData.getPath());
            System.out.println("事件监听Data：" + childData.getData());
            System.out.println("事件监听Stat：" + childData.getStat());
        };

        nodeCache.getListenable().addListener(listener);
        nodeCache.start();

        System.out.println("第一次...");
        client.setData().forPath("/test","afdaf".getBytes());
        System.out.println("第二次...");
        client.setData().forPath("/test","afdaf".getBytes());
        System.out.println("第三次...");
        client.setData().forPath("/test","afdaf".getBytes());
    }

}

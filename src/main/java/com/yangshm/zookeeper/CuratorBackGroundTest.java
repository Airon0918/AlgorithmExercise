package com.yangshm.zookeeper;

import org.apache.curator.RetryPolicy;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.apache.zookeeper.AsyncCallback;
import org.apache.zookeeper.data.Stat;
import org.junit.Test;

public class CuratorBackGroundTest {
    private String testPath = "/test";

    @Test
    public void testBackGround() throws Exception {
        RetryPolicy retryPolicy = new ExponentialBackoffRetry(1000, 3);
        CuratorFramework client = CuratorFrameworkFactory.newClient("127.0.0.1:2181", retryPolicy);

        AsyncCallback.StringCallback callback = (int var1, String var2, Object var3, String var4) -> {
            System.out.println("var1" + var1);
            System.out.println("var2" + var2);
            System.out.println("var3" + var3);
            System.out.println("var4" + var4);
        };

        client.start();
        Stat stat = client.checkExists().forPath(testPath);
        if (stat == null) {
            client.create().forPath(testPath);
        }
        client.setData().inBackground(callback).forPath("/aa");
        Thread.sleep(1000000);
    }
}

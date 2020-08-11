package com.yangshm.redis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class RedislUtil {
    private static JedisPool pool;

    static {
        //1、连接池基本配置信息
        JedisPoolConfig poolConfig = new JedisPoolConfig();
        poolConfig.setMaxTotal(5);//最大连接数
        poolConfig.setMaxIdle(1);//最大空闲数

        //2、连接池
        String host = "127.0.0.1";
        int port = 6379;
        pool = new JedisPool(poolConfig, host, port);
    }

    public static Jedis getJedis() {
        Jedis jedis = pool.getResource();
//        jedis.auth("");
        return jedis;
    }

    public static void close(Jedis jedis) {
        jedis.close();
    }
}

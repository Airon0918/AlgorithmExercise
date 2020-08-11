package com.yangshm.redis;

import com.yangshm.redis.service.UserService;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import redis.clients.jedis.Jedis;

import java.util.HashMap;
import java.util.Map;

public class RedisDemo {
    public static void main(String[] args) {

    }

    public void test1() {
        Jedis jedis = RedislUtil.getJedis();
        String key = "test1";
        if (jedis.exists(key)) {
            String value = jedis.get(key);
            System.out.println(value);
        } else {
            jedis.set(key, "1");
        }
        RedislUtil.close(jedis);
    }

    @Test
    public void test2() {
        Jedis jedis = RedislUtil.getJedis();
        String key = "user1";
        if (jedis.exists(key)) {
            Map<String, String> map = jedis.hgetAll(key);
            System.out.println(map);
        } else {
            jedis.hset(key, "id", "1");
            jedis.hset(key, "name", "aa");
            jedis.hset(key, "age", "22");
        }
        RedislUtil.close(jedis);
    }

    @Test
    public void test3() {
        Jedis jedis = RedislUtil.getJedis();
        String key = "user2";
        if (jedis.exists(key)) {
            Map<String, String> map = jedis.hgetAll(key);
            System.out.println(map);
        } else {
            User user = new User(1, "22", 22);
            Map<String, String> hash = new HashMap<>();
            hash.put("id", user.getId().toString());
            hash.put("name", user.getName());
            hash.put("age", user.getAge().toString());
            jedis.hmset(key, hash);
        }
        RedislUtil.close(jedis);
    }

    @Test
    public void testRedisTemplate() {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("spring-core.xml", "spring-redis.xml");
        UserService userService = ctx.getBean(UserService.class);
        String key = "appName";
        String res = userService.getString(key);
        System.out.println(res);
    }
}

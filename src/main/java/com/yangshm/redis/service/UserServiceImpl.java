package com.yangshm.redis.service;

import com.yangshm.redis.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    RedisTemplate<String, String> redisTemplate;

    @Resource(name = "redisTemplate")
    ValueOperations<String,String> redisString;

    @Resource(name = "redisTemplate")
    HashOperations<String,Integer,User> redisHash;

    @Override
    public String getString(String key) {
        ValueOperations<String, String> string = redisTemplate.opsForValue();

        redisTemplate.opsForValue().set("test", "1", 2, TimeUnit.HOURS);

        if (redisTemplate.hasKey(key)) {
            System.out.println("Redis");
            return string.get(key);
        } else {
            System.out.println("DataBase");
            string.set(key, "1");
            return "查询数据库";
        }
    }

    @Override
    public User login(String name, String pwd) {
        return null;
    }

    @Override
    public String loginValdate(String name) {
        //记录登录次数
        String key = User.getLoginCountFailKey(name);
        int num = 5;
        if (!redisTemplate.hasKey(key)) {
            //第一次登录失败，设置有效期
            redisTemplate.opsForValue().set(key, "1");
            redisTemplate.expire(key, 2, TimeUnit.MINUTES);
            return "剩余失败次数：" + (num - 1);
        } else {
            //查询失败次数
            redisTemplate.opsForValue().get(key);
            long loginFailCount = Long.parseLong(redisTemplate.opsForValue().get(key));
            if (loginFailCount < num - 1) {
                //失败次数+1
                redisTemplate.opsForValue().increment(key, 1);
                long seconds = redisTemplate.getExpire(key, TimeUnit.SECONDS);
                return seconds + "秒内还可以失败次数：" + (num - loginFailCount - 1);
            } else {
                //限制登录
                redisTemplate.opsForValue().set(User.getLoginTimeLockKey(name), "1");
                redisTemplate.expire(User.getLoginTimeLockKey(name), 1, TimeUnit.HOURS);
                return "登录限制1小时";
            }
        }
    }

    /**
     * 1、判断当前用户是否被登录限制
     */
    @Override
    public Map<String, Object> loginUserLock(String name) {
        String key = User.getLoginTimeLockKey(name);
        Map<String, Object> map = new HashMap<>();

        if (redisTemplate.hasKey(key)) {
            //如果存在
            long lockTime = redisTemplate.getExpire(key, TimeUnit.MINUTES);
            map.put("flag", true);
            map.put("lockTime", lockTime);
        } else {
            map.put("flag", false);
        }
        return map;
    }
}

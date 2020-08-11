package com.yangshm.redis.service;

import com.yangshm.redis.User;

import java.util.Map;

public interface UserService {

    String getString(String key);

    User login(String name, String pwd);

    String loginValdate(String name);

    Map<String, Object> loginUserLock(String name);

}

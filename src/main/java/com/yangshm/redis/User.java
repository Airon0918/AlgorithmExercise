package com.yangshm.redis;

import lombok.Data;

import java.io.Serializable;

@Data
public class User implements Serializable {
    private Integer id;
    private String name;
    private String pwd;
    private Integer age;

    public User() {
    }

    public User(Integer id, String name, Integer age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public static String getLoginTimeLockKey(String name) {
        return "user:loginTime:lock:" + name;
    }

    public static String getLoginCountFailKey(String name) {
        return "user:loginCount:fail:" + name;
    }
}

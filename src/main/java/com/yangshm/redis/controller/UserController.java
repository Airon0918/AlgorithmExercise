package com.yangshm.redis.controller;

import com.yangshm.redis.User;
import com.yangshm.redis.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@ResponseBody
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;

    public String login(@RequestParam(name = "name", required = true) final String name,
                        @RequestParam(name = "pwd", required = false) final String pwd,
                        @RequestParam(name = "valcode", required = false) final String valcode) {
        String result = "";
        //验证码比较

        //是否限制登录
        Map<String, Object> map = userService.loginUserLock(name);

        if ((boolean) map.get("flag")) {
            result = "登录限制，剩余时间：" + map.get("lockTime") + "分钟!";
        } else {
            //登录
            User user = userService.login(name, pwd);

            //判断登录是否成功
            if (null != user) {
                //清空对应的所有key

                return "success";
            } else {
                return userService.loginValdate(name);
            }
        }
        return result;
    }
}

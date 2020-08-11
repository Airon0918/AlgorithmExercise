package com.yangshm.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
@RequestMapping(value = "/bd/marclass")
public class DispatcherServletTest {
    @RequestMapping(value = "/list", method = RequestMethod.POST)
    @ResponseBody
    public void lst(@RequestBody Map<String, Object> searchMap) {
        System.out.println("================");
    }
}

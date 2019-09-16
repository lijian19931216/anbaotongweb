package com.anbaotong.anbaotong.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @description:
 * @author: lijian
 * @create: 2019-09-16
 **/
@RestController
public class TestController {
    @RequestMapping("/hello")
    public Map test(){
        Map<String, Object> param = new HashMap<>();
        param.put("name", "lijian");
        return param ;
    }
}

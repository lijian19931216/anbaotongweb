package com.anbaotong.controller;

import com.anbaotong.bean.Product;
import com.anbaotong.mapper.TestMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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
        List list = new ArrayList();
        for (int i=0;i<2;i++){
            Map map = new HashMap();
            map.put("src","images/products/video_meeting/1.jpg");
            map.put("name", "视频会议");
            list.add(map);
        }
        param.put("producList", list);
        return param ;
    }
    @Autowired
    TestMapper mapper;
    @RequestMapping("/product")
    public Product test1(){

        return mapper.selectProduct() ;
    }

}

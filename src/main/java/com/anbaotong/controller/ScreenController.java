package com.anbaotong.controller;

import com.anbaotong.bean.ProductScreen;
import com.anbaotong.mapper.ScreenMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * @description:
 * @author: lijian
 * @create: 2019-09-26
 **/
@RestController
public class ScreenController {
    @Autowired
    private ScreenMapper screenMapper;

    /**
     * 查询幕布列表
     * @return
     */
    @RequestMapping("/screenList")
    public List<Map> screenList(){

        return screenMapper.getProductList();
    }

    /**
     * 根据ID查询详情
     * @return
     */
    @RequestMapping("/screenDetail")
    public ProductScreen screenDetail(String id){

        return screenMapper.getProductDetail(id);
    }
}

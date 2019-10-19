package com.anbaotong.controller;

import com.anbaotong.bean.New;
import com.anbaotong.bean.Result;
import com.anbaotong.service.NewService;
import com.anbaotong.util.UuidUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @description:
 * @author: lijian
 * @create: 2019-09-28
 **/
@RestController
@RequestMapping("/news")
@Slf4j
public class NewsController {
    @Autowired
    private NewService newService;

    @RequestMapping("/addNews")
    public Result addNews(New news) {
        news.setId(UuidUtil.createID());
        newService.addNews(news);
        return new Result("0","新增成功");
    }
    @RequestMapping("/newsList")
    public List<New> newsList(New news) {
        return newService.listNews(news);
    }
    @RequestMapping("/newsDetail")
    public New getNewsDetail(New news) {
       return newService.getNewDetail(news);
    }


}

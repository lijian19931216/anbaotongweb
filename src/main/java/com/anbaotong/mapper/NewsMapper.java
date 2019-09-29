package com.anbaotong.mapper;

import com.anbaotong.bean.New;

import java.util.List;

/**
 * @description:
 * @author: lijian
 * @create: 2019-09-29
 **/
public interface NewsMapper {
//    新增新闻
    int addNews(New news);
//查询新闻列表
    List<New> listNews(New news);
//    查询新闻详情
    New getNewDetail(New news);
}

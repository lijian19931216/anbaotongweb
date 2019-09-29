package com.anbaotong.service.impl;

import com.anbaotong.bean.New;
import com.anbaotong.mapper.NewsMapper;
import com.anbaotong.service.NewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @description:
 * @author: lijian
 * @create: 2019-09-29
 **/
@Transactional
@Service
public class NewServiceImpl implements NewService {
    @Autowired
    private NewsMapper newsMapper;
    @Override
    public int addNews(New news) {
        return newsMapper.addNews(news);
    }

    @Override
    public List<New> listNews(New news) {
        return newsMapper.listNews(news);
    }

    @Override
    public New getNewDetail(New news) {
        return newsMapper.getNewDetail(news);
    }
}

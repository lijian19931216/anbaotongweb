package com.anbaotong.service;

import com.anbaotong.bean.BaikeBean;
import com.anbaotong.bean.ImageBean;

public interface BaikeService {
    void addBaike(BaikeBean baikeBean, ImageBean imageBean);

    Object listBaike(BaikeBean baikeBean);

    BaikeBean getBaikeDetail(BaikeBean baikeBean);
}

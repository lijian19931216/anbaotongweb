package com.anbaotong.service;

import com.anbaotong.bean.BaikeBean;
import com.anbaotong.bean.ImageBean;

import java.util.List;

public interface BaikeService {
    void addBaike(BaikeBean baikeBean, ImageBean imageBean);

    List<BaikeBean> listBaike(BaikeBean baikeBean);

    BaikeBean getBaikeDetail(BaikeBean baikeBean);
}

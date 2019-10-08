package com.anbaotong.mapper;

import com.anbaotong.bean.BaikeBean;
import com.anbaotong.bean.ImageBean;

import java.util.List;

public interface BaikeMapper {
    void insertBaike(BaikeBean baikeBean);
    void insertImage(ImageBean imageBean);

    List<BaikeBean> selectBaikeListByType(BaikeBean baikeBean);

    BaikeBean getBaikeDetail(BaikeBean baikeBean);
}

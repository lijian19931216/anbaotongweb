package com.anbaotong.mapper;

import com.anbaotong.bean.ZhengProductBean;
import com.anbaotong.bean.ImageBean;

import java.util.List;

public interface ZhengProductMapper {
    void insertZhengProduct(ZhengProductBean zhengProductBean);
    void insertImage(ImageBean imageBean);

    List<ZhengProductBean> selectZhengProductListByType(ZhengProductBean zhengProductBean);

    ZhengProductBean getZhengProductDetail(ZhengProductBean zhengProductBean);
}

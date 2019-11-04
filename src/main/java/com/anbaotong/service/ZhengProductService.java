package com.anbaotong.service;

import com.anbaotong.bean.ZhengProductBean;
import com.anbaotong.bean.ImageBean;

/**
 * @description:
 * @author: lijian
 * @create: 2019-11-04
 **/
public interface ZhengProductService {

    void addZhengProduct(ZhengProductBean zhengProductBean, ImageBean imageBean);

    Object listZhengProduct(ZhengProductBean zhengProductBean);

    ZhengProductBean getZhengProductDetail(ZhengProductBean zhengProductBean);
}

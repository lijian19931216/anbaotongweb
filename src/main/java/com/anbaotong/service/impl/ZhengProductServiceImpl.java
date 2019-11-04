package com.anbaotong.service.impl;

import com.anbaotong.aspect.Paginate;
import com.anbaotong.bean.ZhengProductBean;
import com.anbaotong.bean.ImageBean;
import com.anbaotong.mapper.ZhengProductMapper;
import com.anbaotong.service.ZhengProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @description:
 * @author: lijian
 * @create: 2019-10-05
 **/
@Service
@Transactional
public class ZhengProductServiceImpl implements ZhengProductService {

    @Autowired
    private ZhengProductMapper zhengProductMapper;
    @Override
    public void addZhengProduct(ZhengProductBean zhengProductBean, ImageBean imageBean) {
        zhengProductMapper.insertZhengProduct(zhengProductBean);
        zhengProductMapper.insertImage(imageBean);
    }

    @Override
    @Paginate
    public Object listZhengProduct(ZhengProductBean zhengProductBean) {
        return zhengProductMapper.selectZhengProductListByType(zhengProductBean);
    }

    @Override
    public ZhengProductBean getZhengProductDetail(ZhengProductBean zhengProductBean) {
        return zhengProductMapper.getZhengProductDetail(zhengProductBean);
    }
}

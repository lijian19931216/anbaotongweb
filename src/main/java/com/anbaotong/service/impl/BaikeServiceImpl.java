package com.anbaotong.service.impl;

import com.anbaotong.aspect.Paginate;
import com.anbaotong.bean.BaikeBean;
import com.anbaotong.bean.ImageBean;
import com.anbaotong.mapper.BaikeMapper;
import com.anbaotong.service.BaikeService;
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
public class BaikeServiceImpl implements BaikeService {

    @Autowired
    private BaikeMapper baikeMapper;
    @Override
    public void addBaike(BaikeBean baikeBean, ImageBean imageBean) {
        baikeMapper.insertBaike(baikeBean);
        baikeMapper.insertImage(imageBean);
    }

    @Override
    @Paginate
    public Object listBaike(BaikeBean baikeBean) {
        return baikeMapper.selectBaikeListByType(baikeBean);
    }

    @Override
    public BaikeBean getBaikeDetail(BaikeBean baikeBean) {
        return baikeMapper.getBaikeDetail(baikeBean);
    }
}

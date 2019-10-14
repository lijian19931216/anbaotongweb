package com.anbaotong.service.impl;

import com.anbaotong.bean.BusiBean;
import com.anbaotong.mapper.BusiMapper;
import com.anbaotong.service.BusiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @description:
 * @author: lijian
 * @create: 2019-10-11
 **/
@Service
@Transactional
public class BusiServiceImpl implements BusiService {
    @Autowired
    private BusiMapper busiMapper;
    @Override
    public void addBusi(BusiBean busiBean) {
        busiMapper.addBusi(busiBean);
    }

    @Override
    public BusiBean getBusiDetail(BusiBean busiBean) {
        return busiMapper.getBusiDetail(busiBean);
    }
}

package com.anbaotong.service.impl;

import com.anbaotong.bean.RuoDianBean;
import com.anbaotong.bean.ImageBean;
import com.anbaotong.mapper.RuoDianMapper;
import com.anbaotong.service.RuoDianService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * @description:
 * @author: lijian
 * @create: 2019-10-05
 **/
@Service
@Transactional
public class RuoDianServiceImpl implements RuoDianService {

    @Autowired
    private RuoDianMapper ruoDianMapper;
    @Override
    public void addRuoDian(RuoDianBean ruoDianBean, ImageBean imageBean) {
        ruoDianMapper.insertRuoDian(ruoDianBean);
        ruoDianMapper.insertImage(imageBean);
    }

    @Override
    public List<RuoDianBean> listRuoDian(RuoDianBean ruoDianBean) {
        return ruoDianMapper.selectRuoDianListByType(ruoDianBean);
    }

    @Override
    public RuoDianBean getRuoDianDetail(RuoDianBean ruoDianBean) {
        return ruoDianMapper.getRuoDianDetail(ruoDianBean);
    }

    @Override
    public List<Map> getRuoDianType() {
        return  ruoDianMapper.getRuoDianType();
    }
}

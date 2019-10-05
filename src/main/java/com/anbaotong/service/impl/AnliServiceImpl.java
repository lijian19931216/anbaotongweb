package com.anbaotong.service.impl;

import com.anbaotong.bean.AnliBean;
import com.anbaotong.bean.ImageBean;
import com.anbaotong.mapper.AnliMapper;
import com.anbaotong.service.AnliService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @description:
 * @author: lijian
 * @create: 2019-10-05
 **/
@Service
@Transactional
public class AnliServiceImpl implements AnliService {

    @Autowired
    private AnliMapper anliMapper;
    @Override
    public void addAnli(AnliBean anliBean, ImageBean imageBean) {
        anliMapper.insertAnli(anliBean);
        anliMapper.insertImage(imageBean);
    }

    @Override
    public List<AnliBean> listAnli(AnliBean anliBean) {
        return anliMapper.selectAnliListByType(anliBean);
    }

    @Override
    public AnliBean getAnliDetail(AnliBean anliBean) {
        return anliMapper.getAnliDetail(anliBean);
    }
}

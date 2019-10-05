package com.anbaotong.service;

import com.anbaotong.bean.AnliBean;
import com.anbaotong.bean.ImageBean;

import java.util.List;

public interface AnliService {
    void addAnli(AnliBean anliBean, ImageBean imageBean);

    List<AnliBean> listAnli(AnliBean anliBean);

    AnliBean getAnliDetail(AnliBean anliBean);
}

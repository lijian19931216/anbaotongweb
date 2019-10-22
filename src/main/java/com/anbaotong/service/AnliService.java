package com.anbaotong.service;

import com.anbaotong.bean.AnliBean;
import com.anbaotong.bean.ImageBean;

public interface AnliService {
    void addAnli(AnliBean anliBean, ImageBean imageBean);

    Object listAnli(AnliBean anliBean);

    AnliBean getAnliDetail(AnliBean anliBean);
}

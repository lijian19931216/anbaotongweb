package com.anbaotong.mapper;

import com.anbaotong.bean.AnliBean;
import com.anbaotong.bean.ImageBean;

import java.util.List;

public interface AnliMapper {
    void insertAnli(AnliBean anliBean);
    void insertImage(ImageBean imageBean);

    List<AnliBean> selectAnliListByType(AnliBean anliBean);

    AnliBean getAnliDetail(AnliBean anliBean);
}

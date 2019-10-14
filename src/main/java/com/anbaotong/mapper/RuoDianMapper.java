package com.anbaotong.mapper;

import com.anbaotong.bean.RuoDianBean;
import com.anbaotong.bean.ImageBean;

import java.util.List;
import java.util.Map;

public interface RuoDianMapper {
    void insertRuoDian(RuoDianBean ruoDianBean);
    void insertImage(ImageBean imageBean);

    List<RuoDianBean> selectRuoDianListByType(RuoDianBean ruoDianBean);

    RuoDianBean getRuoDianDetail(RuoDianBean ruoDianBean);

    List<Map> getRuoDianType();
}

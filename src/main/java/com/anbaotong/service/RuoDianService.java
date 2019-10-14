package com.anbaotong.service;

import com.anbaotong.bean.RuoDianBean;
import com.anbaotong.bean.ImageBean;

import java.util.List;
import java.util.Map;

public interface RuoDianService {
    void addRuoDian(RuoDianBean ruoDianBean, ImageBean imageBean);

    List<RuoDianBean> listRuoDian(RuoDianBean ruoDianBean);

    RuoDianBean getRuoDianDetail(RuoDianBean ruoDianBean);

    List<Map> getRuoDianType();
}

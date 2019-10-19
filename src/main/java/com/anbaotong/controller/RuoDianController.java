package com.anbaotong.controller;

import com.anbaotong.bean.RuoDianBean;
import com.anbaotong.bean.ImageBean;
import com.anbaotong.bean.Result;
import com.anbaotong.service.RuoDianService;
import com.anbaotong.util.FileUtil;
import com.anbaotong.util.UuidUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

/**
 * @description:
 * @author: lijian
 * @create: 2019-10-05
 **/
@RestController
@RequestMapping("/ruoDian")
@Slf4j
public class RuoDianController {
    @Autowired
    private RuoDianService ruoDianService;

    @RequestMapping("/addRuoDian")
    public Result addRuoDian(RuoDianBean ruoDianBean) {
        log.info(ruoDianBean.toString());
        String id = UuidUtil.createID();
        ruoDianBean.setId(id);
        ImageBean imageBean = FileUtil.uploadImage(ruoDianBean.getFile());
        imageBean.setForeignId(id);
        ruoDianService.addRuoDian(ruoDianBean,imageBean);
        return new Result("0","新增成功");
    }
    @RequestMapping("/ruoDianList")
    public List<RuoDianBean> ruoDianList(RuoDianBean ruoDianBean) {
        return ruoDianService.listRuoDian(ruoDianBean);
    }
    @RequestMapping("/ruoDianDetail")
    public RuoDianBean getNewsDetail(RuoDianBean ruoDianBean) {
        return ruoDianService.getRuoDianDetail(ruoDianBean);
    }
    @RequestMapping("/ruoDianType")
    public List<Map> ruoDianType() {
        return ruoDianService.getRuoDianType();
    }


}

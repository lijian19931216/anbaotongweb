package com.anbaotong.controller;

import com.anbaotong.bean.AnliBean;
import com.anbaotong.bean.ImageBean;
import com.anbaotong.bean.Result;
import com.anbaotong.service.AnliService;
import com.anbaotong.util.FileUtil;
import com.anbaotong.util.UuidUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description:
 * @author: lijian
 * @create: 2019-10-05
 **/
@RestController
@RequestMapping("/anli")
@Slf4j
public class AnliController {
    @Autowired
    private AnliService anliService;

    @RequestMapping("/addAnli")
    public Result addAnli(AnliBean anliBean) {
        log.info(anliBean.toString());
        String id = UuidUtil.createID();
        anliBean.setId(id);
        ImageBean imageBean = FileUtil.uploadImage(anliBean.getFile());
        imageBean.setForeignId(id);
        anliService.addAnli(anliBean,imageBean);
        return new Result("0","新增成功");
    }
    @RequestMapping("/anliList")
    public Object anliList(AnliBean anliBean) {
        return anliService.listAnli(anliBean);
    }
    @RequestMapping("/anliDetail")
    public AnliBean getNewsDetail(AnliBean anliBean) {
        return anliService.getAnliDetail(anliBean);
    }


}

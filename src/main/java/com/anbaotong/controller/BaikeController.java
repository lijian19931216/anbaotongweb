package com.anbaotong.controller;

import com.anbaotong.bean.BaikeBean;
import com.anbaotong.bean.ImageBean;
import com.anbaotong.bean.Result;
import com.anbaotong.service.BaikeService;
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
@RequestMapping("/baike")
@Slf4j
public class BaikeController {
    @Autowired
    private BaikeService baikeService;

    @RequestMapping("/addBaike")
    public Result addBaike(BaikeBean baikeBean) {
        log.info(baikeBean.toString());
        String id = UuidUtil.createID();
        baikeBean.setId(id);
        ImageBean imageBean = FileUtil.uploadImage(baikeBean.getFile());
        imageBean.setForeignId(id);
        baikeService.addBaike(baikeBean,imageBean);
        return new Result("0","新增成功");
    }
    @RequestMapping("/baikeList")
    public Object BaikeList(BaikeBean baikeBean) {
        return baikeService.listBaike(baikeBean);
    }
    @RequestMapping("/baikeDetail")
    public BaikeBean getNewsDetail(BaikeBean baikeBean) {
        return baikeService.getBaikeDetail(baikeBean);
    }


}

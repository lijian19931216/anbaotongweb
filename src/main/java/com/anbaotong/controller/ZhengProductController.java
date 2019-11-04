package com.anbaotong.controller;

import com.anbaotong.bean.ZhengProductBean;
import com.anbaotong.bean.ImageBean;
import com.anbaotong.bean.Result;
import com.anbaotong.service.ZhengProductService;
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
@RequestMapping("/zzproduct")
@Slf4j
public class ZhengProductController {
    @Autowired
    private ZhengProductService zhengProductService;

    @RequestMapping("/addZhengProduct")
    public Result addZhengProduct(ZhengProductBean zhengProductBean) {
        log.info(zhengProductBean.toString());
        String id = UuidUtil.createID();
        zhengProductBean.setId(id);
        ImageBean imageBean = FileUtil.uploadImage(zhengProductBean.getFile());
        imageBean.setForeignId(id);
        zhengProductService.addZhengProduct(zhengProductBean,imageBean);
        return new Result("0","新增成功");
    }
    @RequestMapping("/zhengProductList")
    public Object zhengProductList(ZhengProductBean zhengProductBean) {
        return zhengProductService.listZhengProduct(zhengProductBean);
    }
    @RequestMapping("/zhengProductDetail")
    public ZhengProductBean getNewsDetail(ZhengProductBean zhengProductBean) {
        return zhengProductService.getZhengProductDetail(zhengProductBean);
    }


}

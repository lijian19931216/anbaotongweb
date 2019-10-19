package com.anbaotong.controller;

import com.anbaotong.bean.ImageBean;
import com.anbaotong.bean.LockBean;
import com.anbaotong.bean.Result;
import com.anbaotong.service.LockService;
import com.anbaotong.util.FileUtil;
import com.anbaotong.util.UuidUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @description:
 * @author: lijian
 * @create: 2019-10-05
 **/
@RestController
@RequestMapping("/lock")
@Slf4j
public class LockController {
    @Autowired
    private LockService lockService;

    @RequestMapping("/addLock")
    public Result addLock(LockBean lockBean) {
        log.info(lockBean.toString());
        String id = UuidUtil.createID();
        lockBean.setId(id);
        ImageBean imageBean = FileUtil.uploadImage(lockBean.getFile());
        imageBean.setForeignId(id);
        lockService.addLock(lockBean,imageBean);
        return new Result("0","新增成功");
    }
    @RequestMapping("/lockList")
    public List<LockBean> lockList(LockBean lockBean) {
        return lockService.listLock(lockBean);
    }
    @RequestMapping("/lockDetail")
    public LockBean getNewsDetail(LockBean lockBean) {
        return lockService.getLockDetail(lockBean);
    }


}

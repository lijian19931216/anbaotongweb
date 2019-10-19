package com.anbaotong.controller;

import com.anbaotong.bean.ImageBean;
import com.anbaotong.bean.ProjectAnliBean;
import com.anbaotong.bean.Result;
import com.anbaotong.service.ProjectAnliService;
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
@RequestMapping("/project")
@Slf4j
public class ProjectAnliController {
    @Autowired
    private ProjectAnliService projectAnliService;

    @RequestMapping("/addAnli")
    public Result addAnli(ProjectAnliBean projectAnliBean) {
        log.info(projectAnliBean.toString());
        String id = UuidUtil.createID();
        projectAnliBean.setId(id);
        ImageBean imageBean = FileUtil.uploadImage(projectAnliBean.getFile());
        imageBean.setForeignId(id);
        projectAnliService.addAnli(projectAnliBean,imageBean);
        return new Result("0","新增成功");
    }
    @RequestMapping("/anliList")
    public List<ProjectAnliBean> projectAnliList(ProjectAnliBean projectAnliBean) {
        return projectAnliService.listAnli(projectAnliBean);
    }
    @RequestMapping("/anliDetail")
    public ProjectAnliBean getNewsDetail(ProjectAnliBean projectAnliBean) {
        return projectAnliService.getAnliDetail(projectAnliBean);
    }


}

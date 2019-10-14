package com.anbaotong.service;

import com.anbaotong.bean.ImageBean;
import com.anbaotong.bean.ProjectAnliBean;

import java.util.List;

public interface ProjectAnliService {

    void addAnli(ProjectAnliBean projectAnliBean, ImageBean imageBean);

    List<ProjectAnliBean> listAnli(ProjectAnliBean projectAnliBean);

    ProjectAnliBean getAnliDetail(ProjectAnliBean projectAnliBean);
}

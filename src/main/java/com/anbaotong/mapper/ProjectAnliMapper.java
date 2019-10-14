package com.anbaotong.mapper;

import com.anbaotong.bean.ImageBean;
import com.anbaotong.bean.ProjectAnliBean;

import java.util.List;

public interface ProjectAnliMapper {
    void insertProjectAnli(ProjectAnliBean projectAnliBean);
    void insertImage(ImageBean imageBean);

    List<ProjectAnliBean> selectProjectAnliListByType(ProjectAnliBean projectAnliBean);

    ProjectAnliBean getProjectAnliDetail(ProjectAnliBean projectAnliBean);
}

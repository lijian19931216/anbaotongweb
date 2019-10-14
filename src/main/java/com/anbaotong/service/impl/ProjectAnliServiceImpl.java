package com.anbaotong.service.impl;

import com.anbaotong.bean.ImageBean;
import com.anbaotong.bean.ProjectAnliBean;
import com.anbaotong.mapper.ProjectAnliMapper;
import com.anbaotong.service.ProjectAnliService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @description:
 * @author: lijian
 * @create: 2019-10-05
 **/
@Service
@Transactional
public class ProjectAnliServiceImpl implements ProjectAnliService {

    @Autowired
    private ProjectAnliMapper projectAnliMapper;
    @Override
    public void addAnli(ProjectAnliBean projectAnliBean, ImageBean imageBean) {
        projectAnliMapper.insertProjectAnli(projectAnliBean);
        projectAnliMapper.insertImage(imageBean);
    }

    @Override
    public List<ProjectAnliBean> listAnli(ProjectAnliBean projectAnliBean) {
        return projectAnliMapper.selectProjectAnliListByType(projectAnliBean);
    }

    @Override
    public ProjectAnliBean getAnliDetail(ProjectAnliBean projectAnliBean) {
        return projectAnliMapper.getProjectAnliDetail(projectAnliBean);
    }
}

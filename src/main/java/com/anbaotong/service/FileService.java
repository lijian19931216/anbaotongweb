package com.anbaotong.service;

import com.anbaotong.bean.BaseBean;
import com.anbaotong.bean.FileBean;

import java.util.List;

public interface FileService {
    //新增文件
    int addFile(List<FileBean> files);
    //查询文件列表
    Object getFileList(BaseBean baseBean);
    //根据id查询保存路径
    FileBean getFileById(FileBean fileBean);
}

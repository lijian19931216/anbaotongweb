package com.anbaotong.mapper;

import com.anbaotong.bean.FileBean;

import java.util.List;

public interface FileMapper {

    //新增文件
    int addFile(List<FileBean> files);
    //查询文件列表
    List<FileBean> getFileList();
    //根据id查询保存路径
    FileBean getFileById(FileBean fileBean);
}

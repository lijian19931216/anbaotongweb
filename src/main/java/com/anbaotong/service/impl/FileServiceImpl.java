package com.anbaotong.service.impl;

import com.anbaotong.aspect.Paginate;
import com.anbaotong.bean.BaseBean;
import com.anbaotong.bean.FileBean;
import com.anbaotong.mapper.FileMapper;
import com.anbaotong.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @description:
 * @author: lijian
 * @create: 2019-09-30
 **/
@Service
@Transactional
public class FileServiceImpl implements FileService {
    @Autowired
    private FileMapper fileMapper;
    @Override
    public int addFile(List<FileBean> files) {
        return fileMapper.addFile(files);
    }

    @Override
    @Paginate
    public Object getFileList(BaseBean baseBean) {
        return fileMapper.getFileList();
    }

    @Override
    public FileBean getFileById(FileBean fileBean) {
        return fileMapper.getFileById(fileBean);
    }
}

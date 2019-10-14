package com.anbaotong.service.impl;

import com.anbaotong.bean.LockBean;
import com.anbaotong.bean.ImageBean;
import com.anbaotong.mapper.LockMapper;
import com.anbaotong.service.LockService;
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
public class LockServiceImpl implements LockService {

    @Autowired
    private LockMapper lockMapper;
    @Override
    public void addLock(LockBean lockBean, ImageBean imageBean) {
        lockMapper.insertLock(lockBean);
        lockMapper.insertImage(imageBean);
    }

    @Override
    public List<LockBean> listLock(LockBean lockBean) {
        return lockMapper.selectLockListByType(lockBean);
    }

    @Override
    public LockBean getLockDetail(LockBean lockBean) {
        return lockMapper.getLockDetail(lockBean);
    }
}

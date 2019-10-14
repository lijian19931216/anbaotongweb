package com.anbaotong.service;

import com.anbaotong.bean.LockBean;
import com.anbaotong.bean.ImageBean;

import java.util.List;

public interface LockService {
    void addLock(LockBean lockBean, ImageBean imageBean);

    List<LockBean> listLock(LockBean lockBean);

    LockBean getLockDetail(LockBean lockBean);
}

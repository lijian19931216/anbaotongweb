package com.anbaotong.mapper;

import com.anbaotong.bean.LockBean;
import com.anbaotong.bean.ImageBean;

import java.util.List;

public interface LockMapper {
    void insertLock(LockBean lockBean);
    void insertImage(ImageBean imageBean);

    List<LockBean> selectLockListByType(LockBean lockBean);

    LockBean getLockDetail(LockBean lockBean);
}

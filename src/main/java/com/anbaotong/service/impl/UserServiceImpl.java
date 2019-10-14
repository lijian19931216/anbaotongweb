package com.anbaotong.service.impl;

import com.anbaotong.bean.UserBean;
import com.anbaotong.mapper.UserMapper;
import com.anbaotong.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @description:
 * @author: lijian
 * @create: 2019-10-12
 **/
@Service
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Override
    public void addUser(UserBean userBean) {
        userMapper.addUser(userBean);
    }
}

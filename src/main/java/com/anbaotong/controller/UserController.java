package com.anbaotong.controller;

import com.anbaotong.bean.Result;
import com.anbaotong.bean.UserBean;
import com.anbaotong.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description:
 * @author: lijian
 * @create: 2019-10-05
 **/
@RestController
@RequestMapping("/user")
@Slf4j
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("/addUser")
    public Result addUser(UserBean userBean) {
        log.info(userBean.toString());
        userService.addUser(userBean);
        return new Result("0","新增成功");
    }


}

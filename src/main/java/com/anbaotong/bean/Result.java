package com.anbaotong.bean;

import lombok.Data;

/**
 * @description:
 * @author: lijian
 * @create: 2019-09-29
 **/
@Data
public class Result {
    private String code;
    private String desc ;

    public Result(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }
}

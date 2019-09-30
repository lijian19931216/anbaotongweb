package com.anbaotong.bean;

import lombok.Data;

import java.util.Date;

/**
 * @description:
 * @author: lijian
 * @create: 2019-09-30
 **/
@Data
public class FileBean {
    private String id;
    private String oriName;
    private String newName;
    private String savePath;
    private Date time;
}

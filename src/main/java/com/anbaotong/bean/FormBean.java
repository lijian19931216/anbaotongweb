package com.anbaotong.bean;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

/**
 * @description:
 * @author: lijian
 * @create: 2019-09-26
 **/
@Data
public class FormBean {
    private String id;
    private String prodctName;
    private String productDesc;
    private String dirName;
    private MultipartFile[] fengmianFiles;
    private MultipartFile[] nofengmianFiles;
    private MultipartFile[] detailFiles;
}

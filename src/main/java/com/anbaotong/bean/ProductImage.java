package com.anbaotong.bean;

import lombok.Data;

/**
 * @description:
 * @author: lijian
 * @create: 2019-09-26
 **/
@Data
public class ProductImage {
    private String proId;
    private String newImgName;
    private String oriImgName;
    private String imgUrl;
    private int status;

}

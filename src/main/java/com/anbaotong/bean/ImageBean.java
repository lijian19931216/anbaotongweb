package com.anbaotong.bean;

import lombok.Data;

@Data
public class ImageBean {
    /**
     * 外部ID
     */
    private String foreignId;

    /**
     * 原始名称
     */
    private String oriImgName;

    /**
     * 图片名称
     */
    private String newImgName;

    /**
     * 图片地址
     */
    private String imgUrl;

    /**
     * 0-封面图 1-非封面图 2-详情图
     */
    private Integer status;

    /**
     * 链接地址
     */
    private String href;

}
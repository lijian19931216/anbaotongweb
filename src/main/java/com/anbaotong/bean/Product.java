package com.anbaotong.bean;

import lombok.Data;

import java.util.List;

/**
 * @description:
 * @author: lijian
 * @create: 2019-09-25
 **/
@Data
public class Product {
    private String id;
    private String name;
    private String desc;
    private String detail;
    private List<ProductImage> productImages;

}

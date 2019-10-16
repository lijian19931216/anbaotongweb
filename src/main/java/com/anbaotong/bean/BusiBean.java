package com.anbaotong.bean;

import lombok.Data;

/**
 * @description:
 * @author: lijian
 * @create: 2019-10-05
 **/
@Data
public class BusiBean {
    /**
     * id
     */
    private int id;

    /**
     * 标题
     */
    private String title;


    private String content;

    private int type;


}

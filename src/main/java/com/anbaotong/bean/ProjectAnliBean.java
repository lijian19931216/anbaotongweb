package com.anbaotong.bean;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

/**
 * @description:
 * @author: lijian
 * @create: 2019-10-05
 **/
@Data
public class ProjectAnliBean {
    /**
     * id
     */
    private String id;

    /**
     * 标题
     */
    private String title;

    /**
     * 类型：
     */
    private Integer type;

    /**
     * 内容
     */
    private String content;

    /**
     * 封面图：图片表的id
     */
    private String image;
    private MultipartFile file;
}

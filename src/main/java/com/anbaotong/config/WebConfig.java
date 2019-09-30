package com.anbaotong.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @description:
 * @author: lijian
 * @create: 2019-09-25
 **/
@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Value("${filepath}")
    private String filepath;

    @Value("${imagepath}")
    private String imagepath;



    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        //外部访问路径映射到本地磁盘路径
        registry.addResourceHandler("/image/**").addResourceLocations("file:"+imagepath);
        registry.addResourceHandler("/file/**").addResourceLocations("file:"+filepath);
    }
}
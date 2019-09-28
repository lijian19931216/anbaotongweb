package com.anbaotong.controller;

import com.anbaotong.util.YamlConfigurerUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

/**
 * @description:
 * @author: lijian
 * @create: 2019-09-28
 **/
@RestController
@Slf4j
public class UeditorController {

    @RequestMapping("/addNews")
    public String addNews(String content) {

        System.out.println(content);
        return "ok";
    }
    @RequestMapping("/upload")
    public Map upload(MultipartFile[] files){
        Map<String, Object> params = new HashMap<>();
        String filePath = YamlConfigurerUtil.getStrYmlVal("filepath");

        for (int i = 0; i < files.length; i++) {
            MultipartFile file = files[i];
            if (file.isEmpty()) {
            }
            //保存文件到本地文件，并保存路径到数据库
            DateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
            Calendar calendar = Calendar.getInstance();

            String originalName = files[i].getOriginalFilename();

            String newFileName = df.format(calendar.getTime()) + originalName;
            log.info("文件的文件名为:" + newFileName);
            //todo 入库

            File targetFile = new File(filePath);
            if (!targetFile.exists()) {
                targetFile.mkdirs();
            }
            File dest = new File(filePath + newFileName);
            try {
                file.transferTo(dest);
                log.info("第" + (i + 1) + "个文件上传成功");
            } catch (IOException e) {
                log.error(e.toString(), e);
            }
            params.put("size", file.getSize());
            params.put("state", "SUCCESS");
            params.put("url", filePath + newFileName);
            params.put("original", newFileName);
        }
            return params;
    }

}

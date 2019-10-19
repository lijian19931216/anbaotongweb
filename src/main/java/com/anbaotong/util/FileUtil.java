package com.anbaotong.util;

import com.anbaotong.bean.ImageBean;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * @description:
 * @author: lijian
 * @create: 2019-09-25
 **/
@Component
@Slf4j
public class FileUtil {
    //文件上传工具类服务方法
    public static void uploadFile(byte[] file, String filePath, String fileName) throws Exception {

        File targetFile = new File(filePath);
        if (!targetFile.exists()) {
            targetFile.mkdirs();
        }
        FileOutputStream out = new FileOutputStream(filePath + fileName);
        out.write(file);
        out.flush();
        out.close();
    }

    private static String imagepath;
    @Value("${imagepath}")
    public void setImagepath(String imagepath) {
        FileUtil.imagepath = imagepath;
    }

    public static ImageBean uploadImage(MultipartFile file){
        ImageBean image = new ImageBean();
        //保存文件到本地文件，并保存路径到数据库
        DateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
        Calendar calendar = Calendar.getInstance();

        String originalName = file.getOriginalFilename();

        String newFileName = df.format(calendar.getTime()) + originalName;
        log.info("文件的文件名为:" + newFileName);
        image.setImgUrl("image/"+newFileName);
        image.setNewImgName(newFileName);
        image.setOriImgName(originalName);
        File targetFile = new File(imagepath);
        if (!targetFile.exists()) {
            targetFile.mkdirs();
        }
        File dest = new File(imagepath + newFileName);
        try {
            file.transferTo(dest);
            log.info(originalName+ "文件上传成功");
        } catch (IOException e) {
            log.error(e.toString(), e);
        }
        return image;
    }

}

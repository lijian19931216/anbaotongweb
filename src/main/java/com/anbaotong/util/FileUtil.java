package com.anbaotong.util;

import java.io.File;
import java.io.FileOutputStream;

/**
 * @description:
 * @author: lijian
 * @create: 2019-09-25
 **/
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
}
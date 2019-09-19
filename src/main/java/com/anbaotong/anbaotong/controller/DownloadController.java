package com.anbaotong.anbaotong.controller;

import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.stereotype.Controller;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLEncoder;

/**
 * @description:
 * @author: lijian
 * @create: 2019-09-18
 **/
@Controller
public class DownloadController {

    /**
     * 文件下载接口
     * @param filePath  文件上传时，返回的相对路径
     * @param response
     * @throws Exception
     */
    @RequestMapping(value = "/downloadFile")
    public void downLoad(HttpServletRequest request,String fileName, HttpServletResponse response) throws Exception {

        try {
            File file = ResourceUtils.getFile(ResourceUtils.CLASSPATH_URL_PREFIX + "file/"+fileName);
            InputStream inputStream = new FileInputStream(file);
            OutputStream outputStream = response.getOutputStream();
            response.setCharacterEncoding(request.getCharacterEncoding());
            response.setHeader("Content-Disposition",
                    "attachment; filename="+ URLEncoder.encode(fileName , "UTF-8"));
            response.setContentType("application/octet-stream");
            IOUtils.copy(inputStream, outputStream);
            response.flushBuffer();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

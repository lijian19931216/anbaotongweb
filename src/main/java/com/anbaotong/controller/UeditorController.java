package com.anbaotong.controller;

import com.anbaotong.bean.New;
import com.anbaotong.bean.Result;
import com.anbaotong.bean.UeditorResult;
import com.anbaotong.service.NewService;
import com.anbaotong.util.UuidUtil;
import com.anbaotong.util.YamlConfigurerUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @description:
 * @author: lijian
 * @create: 2019-09-28
 **/
@RestController
@RequestMapping("/news")
@Slf4j
public class UeditorController {
    @Autowired
    private NewService newService;

    @RequestMapping("/addNews")
    public Result addNews(New news) {
        news.setId(UuidUtil.createID());
        newService.addNews(news);
        return new Result("0","新增成功");
    }
    @RequestMapping("/newsList")
    public List<New> newsList(New news) {
        return newService.listNews(news);
    }
    @RequestMapping("/newsDetail")
    public New getNewsDetail(New news) {
       return newService.getNewDetail(news);
    }

    /**
     * 上传图文消息
     * @param file
     * @param request
     * @return
     */
    @RequestMapping("/upload")
    public UeditorResult upload(MultipartFile file, HttpServletRequest request){
        Map<String, Object> params = new HashMap<>();
        String filePath = YamlConfigurerUtil.getStrYmlVal("imagepath");
            if (file.isEmpty()) {
            }
            //保存文件到本地文件，并保存路径到数据库
            DateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
            Calendar calendar = Calendar.getInstance();

            String originalName = file.getOriginalFilename();

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
                log.info("文件上传成功");
            } catch (IOException e) {
                log.error(e.toString(), e);
            }
            params.put("size", file.getSize());
            params.put("state", "SUCCESS");
        String visitPath=
        request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()
                +request.getContextPath()+"/image/";

        UeditorResult ueditorResult = new UeditorResult(file.getSize(), "SUCCESS",
                visitPath + newFileName, newFileName, file.getContentType());
        return ueditorResult;
    }

}

package com.anbaotong.controller;

import com.anbaotong.bean.BaikeBean;
import com.anbaotong.bean.ImageBean;
import com.anbaotong.bean.Result;
import com.anbaotong.service.BaikeService;
import com.anbaotong.util.UuidUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

/**
 * @description:
 * @author: lijian
 * @create: 2019-10-05
 **/
@RestController
@RequestMapping("/baike")
@Slf4j
public class BaikeController {
    @Autowired
    private BaikeService baikeService;

    @RequestMapping("/addBaike")
    public Result addBaike(BaikeBean baikeBean) {
        log.info(baikeBean.toString());
        String id = UuidUtil.createID();
        baikeBean.setId(id);
        ImageBean imageBean = uploadImage(baikeBean.getFile());
        imageBean.setForeignId(id);
        baikeService.addBaike(baikeBean,imageBean);
        return new Result("0","新增成功");
    }
    @RequestMapping("/baikeList")
    public List<BaikeBean> BaikeList(BaikeBean baikeBean) {
        return baikeService.listBaike(baikeBean);
    }
    @RequestMapping("/baikeDetail")
    public BaikeBean getNewsDetail(BaikeBean baikeBean) {
        return baikeService.getBaikeDetail(baikeBean);
    }
    @Value("${imagepath}")
    private String imagepath;

    public ImageBean uploadImage(MultipartFile file){
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

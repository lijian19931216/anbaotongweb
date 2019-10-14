package com.anbaotong.controller;

import com.anbaotong.bean.RuoDianBean;
import com.anbaotong.bean.ImageBean;
import com.anbaotong.bean.Result;
import com.anbaotong.service.RuoDianService;
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
import java.util.Map;

/**
 * @description:
 * @author: lijian
 * @create: 2019-10-05
 **/
@RestController
@RequestMapping("/ruoDian")
@Slf4j
public class RuoDianController {
    @Autowired
    private RuoDianService ruoDianService;

    @RequestMapping("/addRuoDian")
    public Result addRuoDian(RuoDianBean ruoDianBean) {
        log.info(ruoDianBean.toString());
        String id = UuidUtil.createID();
        ruoDianBean.setId(id);
        ImageBean imageBean = uploadImage(ruoDianBean.getFile());
        imageBean.setForeignId(id);
        ruoDianService.addRuoDian(ruoDianBean,imageBean);
        return new Result("0","新增成功");
    }
    @RequestMapping("/ruoDianList")
    public List<RuoDianBean> ruoDianList(RuoDianBean ruoDianBean) {
        return ruoDianService.listRuoDian(ruoDianBean);
    }
    @RequestMapping("/ruoDianDetail")
    public RuoDianBean getNewsDetail(RuoDianBean ruoDianBean) {
        return ruoDianService.getRuoDianDetail(ruoDianBean);
    }
    @RequestMapping("/ruoDianType")
    public List<Map> ruoDianType() {
        return ruoDianService.getRuoDianType();
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

package com.anbaotong.controller;

import com.anbaotong.bean.FormBean;
import com.anbaotong.bean.ProductImage;
import com.anbaotong.mapper.ScreenMapper;
import com.anbaotong.util.FileUtil;
import com.anbaotong.util.UuidUtil;
import com.anbaotong.util.YamlConfigurerUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * @description:
 * @author: lijian
 * @create: 2019-09-25
 **/
@RestController
@Slf4j
public class UpAndDownloadController {



    /* @ResponseBody
            @RequestMapping("/fileUpload")
            public JSONObject fileUpload1(@RequestParam("file") MultipartFile[] files, HttpServletRequest request) throws Exception{
                String serverName = "文件上传";
                fileUpload(files,request);
                Map<String,Object> resMap = new HashMap<String,Object>();
                //0:操作成功
                resMap.put("code", "-1");
                resMap.put("desc","");
                return null;
            }*/
    @RequestMapping("/product1")
    public void fileUpload(@RequestParam("file")MultipartFile[] files, HttpServletRequest request) throws Exception {
        //文件命名
        //保存时的文件名
        for(int i=0;i<files.length;i++) {
            //保存文件到本地文件，并保存路径到数据库
            DateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
            Calendar calendar = Calendar.getInstance();
            String fileName = df.format(calendar.getTime()) + files[i].getOriginalFilename();
            log.info("文件的文件名为:" + fileName);
            //保存文件的绝对路径
            String filePath = request.getSession().getServletContext().getRealPath("static/");
            log.info("文件的绝对路径:" + filePath);
            try {
                //上传文件
                FileUtil.uploadFile(files[i].getBytes(), filePath, fileName);
                //保存到数据库代码，存入路径以及文件名称
            } catch (IllegalStateException | IOException e) {
                e.printStackTrace();
//                throw new ZDYException(ErrorCode.ERR_FILE_UPLOAD_FAIL);
            }
        }
    }
    private void upload(MultipartFile[] files,String id,int status){
        String filePath = YamlConfigurerUtil.getStrYmlVal("filepath");
        List<ProductImage> images = new ArrayList<>();
        ProductImage productImage;
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
            productImage = new ProductImage();
            productImage.setImgUrl("image/"+newFileName);
            productImage.setNewImgName(newFileName);
            productImage.setOriImgName(originalName);
            productImage.setProId(id);
            productImage.setStatus(status);
            images.add(productImage);
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
        }

        screenMapper.insertProductImage(images);
    }
    @Autowired
    ScreenMapper screenMapper;

    @PostMapping("/multiUpload")
    public String multiUpload(FormBean formBean) {
//        upload(fengmianFiles);
//        upload(detailFiles);
//        upload(nofengmianFiles);
        //产品入库
//        String prodctName = formBean.getProdctName();
//        String productDesc = formBean.getProductDesc();
        String id = UuidUtil.createID();
        formBean.setId(id);
        screenMapper.insertProductScreen(formBean);

        upload(formBean.getDetailFiles(),id,2);
        upload(formBean.getNofengmianFiles(),id,1);
        upload(formBean.getFengmianFiles(),id,0);
        return "上传成功";

    }
    /**
     * 文件下载接口
     * @param response
     * @throws Exception
     */
    @RequestMapping(value = "/downloadFile")
    public void downLoad(HttpServletRequest request,String fileName, HttpServletResponse response) throws Exception {

        try {
            File file = new File(YamlConfigurerUtil.getStrYmlVal("filepath") + fileName);
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

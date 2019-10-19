package com.anbaotong.controller;

import com.anbaotong.bean.BaseBean;
import com.anbaotong.bean.FileBean;
import com.anbaotong.bean.FormBean;
import com.anbaotong.bean.ProductImage;
import com.anbaotong.mapper.ScreenMapper;
import com.anbaotong.service.FileService;
import com.anbaotong.util.UuidUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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



   /* @RequestMapping("/product1")
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
    }*/
   @Value("${imagepath}")
   private String imagepath;
    private void upload(MultipartFile[] files,String id,int status){
        String filePath = imagepath;
        List<ProductImage> images = new ArrayList<>();
        ProductImage productImage;
        for (int i = 0; i < files.length; i++) {
            MultipartFile file = files[i];
            if (file.isEmpty()) {
                continue;
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

    /**
     * 屏幕文件上传
     * @param formBean
     * @return
     */

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
    public void downLoad(HttpServletRequest request,FileBean fileBean, HttpServletResponse response) throws Exception {
        FileBean fileDetail = fileService.getFileById(fileBean);
        try {
            File file = new File(fileDetail.getSavePath());
            InputStream inputStream = new FileInputStream(file);
            OutputStream outputStream = response.getOutputStream();
            response.setCharacterEncoding(request.getCharacterEncoding());
            response.setHeader("Content-Disposition",
                    "attachment; filename="+ URLEncoder.encode(fileDetail.getOriName() , "UTF-8"));
            response.setContentType("application/octet-stream");
            IOUtils.copy(inputStream, outputStream);
            response.flushBuffer();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 上传下载文件
     * @param files
     * @param id
     * @param status
     */
    @Value("${filepath}")
    private String filepath;

    @Autowired
    private FileService fileService;
    @RequestMapping("/uploadFile")
    public String uploadFile(MultipartFile[] files){
        List<FileBean> fileList = new ArrayList<>();
        FileBean fileBean;
        for (int i = 0; i < files.length; i++) {
            MultipartFile file = files[i];
            if (file.isEmpty()) {
                continue;
            }
            //保存文件到本地文件，并保存路径到数据库
            DateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
            Calendar calendar = Calendar.getInstance();

            String originalName = files[i].getOriginalFilename();

            String newFileName = df.format(calendar.getTime()) + originalName;
            log.info("文件的文件名为:" + newFileName);
            fileBean = new FileBean();
            fileBean.setId(UuidUtil.createID());
            fileBean.setOriName(originalName);
            fileBean.setSavePath(filepath+newFileName);
            fileBean.setNewName(newFileName);
            fileList.add(fileBean);
            File targetFile = new File(filepath);
            if (!targetFile.exists()) {
                targetFile.mkdirs();
            }
            File dest = new File(filepath + newFileName);
            try {
                file.transferTo(dest);
                log.info(originalName+ "文件上传成功");
            } catch (IOException e) {
                log.error(e.toString(), e);
            }
        }

        fileService.addFile(fileList);
        return "上传成功";
    }

    /**
     * 获取文件列表
     * @return
     */
    @RequestMapping("/getFileList")
    public Object getFileList(BaseBean baseBean){
        return fileService.getFileList(baseBean);
    }
}

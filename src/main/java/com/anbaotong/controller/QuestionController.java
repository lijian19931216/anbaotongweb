package com.anbaotong.controller;

import com.anbaotong.bean.QuesAns;
import com.anbaotong.bean.Result;
import com.anbaotong.bean.UeditorResult;
import com.anbaotong.service.QuestionService;
import com.anbaotong.util.PathUtils;
import com.anbaotong.util.UuidUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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
 * @create: 2019-10-05
 **/
@RestController
@RequestMapping("/question")
@Slf4j
public class QuestionController {
    @Autowired
    private QuestionService questionService;

    @RequestMapping("/addQuestion")
    public Result addQuestion(QuesAns quesAns) {
        quesAns.setId(UuidUtil.createID());
        questionService.addQuestion(quesAns);
        return new Result("0","新增成功");
    }
    @RequestMapping("/questionList")
    public Object questionList(QuesAns quesAns) {
        return questionService.listQuestions(quesAns);
    }
    @RequestMapping("/questionDetail")
    public QuesAns questionDetail(QuesAns quesAns) {
        return questionService.getQuestionDetail(quesAns);
    }
    @RequestMapping("/questionType")
    public List<Map> questionType() {
        return questionService.getQuestionType();
    }

    /**
     * 上传图文消息
     * @param file
     * @param request
     * @return
     */

    @Value("${imagepath}")
    private String filepath;

    @RequestMapping("/upload")
    public UeditorResult upload(MultipartFile file, HttpServletRequest request){
        Map<String, Object> params = new HashMap<>();
//        String filePath = YamlConfigurerUtil.getStrYmlVal("imagepath");
        if (file.isEmpty()) {
        }
        //保存文件到本地文件，并保存路径到数据库
        DateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
        Calendar calendar = Calendar.getInstance();

        String originalName = file.getOriginalFilename();

        String newFileName = df.format(calendar.getTime()) + originalName;
        log.info("文件的文件名为:" + newFileName);
        //todo 入库
        File targetFile = new File(filepath);
        if (!targetFile.exists()) {
            targetFile.mkdirs();
        }
        File dest = new File(filepath + newFileName);
        try {
            file.transferTo(dest);
            log.info("文件上传成功");
        } catch (IOException e) {
            log.error(e.toString(), e);
        }
        params.put("size", file.getSize());
        params.put("state", "SUCCESS");
        String visitPath= PathUtils.getContexPath(request)+"/image/";

        UeditorResult ueditorResult = new UeditorResult(file.getSize(), "SUCCESS",
                visitPath + newFileName, newFileName, file.getContentType());
        return ueditorResult;
    }
}

package com.anbaotong.controller;

import com.anbaotong.bean.QuesAns;
import com.anbaotong.bean.Result;
import com.anbaotong.service.QuestionService;
import com.anbaotong.util.UuidUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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


}

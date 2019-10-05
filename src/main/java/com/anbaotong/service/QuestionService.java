package com.anbaotong.service;

import com.anbaotong.bean.QuesAns;

import java.util.List;
import java.util.Map;

/**
 * @description:
 * @author: lijian
 * @create: 2019-10-05
 **/
public interface QuestionService {
    //新增问题答案
     void addQuestion(QuesAns quesAns) ;

    List<QuesAns> listQuestions(QuesAns quesAns);

    QuesAns getQuestionDetail(QuesAns quesAns);

    List<Map> getQuestionType();
}

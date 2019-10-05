package com.anbaotong.mapper;

import com.anbaotong.bean.QuesAns;

import java.util.List;
import java.util.Map;

public interface QuestionMapper {
    //新增
    void addQuestion(QuesAns quesAns);
    //查询列表
    List<QuesAns> listQuestions(QuesAns quesAns);
    //查询详情
    QuesAns getQuestionDetail(QuesAns quesAns);

    List<Map> getQuestionType();
}

package com.anbaotong.service.impl;

import com.anbaotong.bean.QuesAns;
import com.anbaotong.mapper.QuestionMapper;
import com.anbaotong.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * @description:
 * @author: lijian
 * @create: 2019-10-05
 **/
@Transactional
@Service
public class QuestionServiceImpl implements QuestionService {
    @Autowired
    private QuestionMapper questionMapper;
    @Override
    public void addQuestion(QuesAns quesAns) {
         questionMapper.addQuestion(quesAns);
    }

    @Override
    public List<QuesAns> listQuestions(QuesAns quesAns) {
        return questionMapper.listQuestions(quesAns);
    }

    @Override
    public QuesAns getQuestionDetail(QuesAns quesAns) {
        return questionMapper.getQuestionDetail(quesAns);
    }

    @Override
    public List<Map> getQuestionType() {
        return questionMapper.getQuestionType();
    }


}

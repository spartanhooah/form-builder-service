package com.indeed.forms.builder.bo;

import com.indeed.forms.builder.dao.QuestionDao;
import com.indeed.forms.builder.question.Question;

import javax.inject.Inject;

import static java.util.UUID.fromString;

public class QuestionBo {
    @Inject
    QuestionDao questionDao;

    public Question getQuestion(String id) {
        return questionDao.getQuestion(fromString(id));
    }

    public void addQuestion(Question question) {
        questionDao.add(question);
    }
}

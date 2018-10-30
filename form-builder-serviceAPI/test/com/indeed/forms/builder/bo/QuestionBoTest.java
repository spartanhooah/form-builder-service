package com.indeed.forms.builder.bo;

import com.indeed.forms.builder.dao.QuestionDao;
import com.indeed.forms.builder.question.Question;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static java.util.UUID.fromString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class QuestionBoTest {
    @Mock
    QuestionDao questionDao;

    @InjectMocks
    private QuestionBo questionBo;
    private Question question;

    @Before
    public void setUp() {
        questionBo = new QuestionBo();
        question = new Question();
        question.setId("1");

        when(questionDao.getQuestion(fromString("1"))).thenReturn(question);
    }

    @Test
    public void getQuestion() {
        Question result = questionBo.getQuestion("1");
        assertThat(result, is(question));
    }
}
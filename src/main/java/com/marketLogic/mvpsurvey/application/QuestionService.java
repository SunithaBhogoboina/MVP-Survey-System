package com.marketlogic.mvpsurvey.application;

import com.marketlogic.mvpsurvey.domain.Question;

import java.util.List;

public interface QuestionService {
    public Iterable<Question> addQuestions(List<Question> questions) throws Exception;
}

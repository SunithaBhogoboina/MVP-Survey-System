package com.marketLogic.mvpsurvey.application;

import com.marketLogic.mvpsurvey.domain.Question;

import java.util.List;

public interface QuestionService {
    public Iterable<Question> addQuestions(List<Question> questions);
}

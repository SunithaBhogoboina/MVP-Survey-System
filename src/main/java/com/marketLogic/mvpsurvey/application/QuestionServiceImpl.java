package com.marketLogic.mvpsurvey.application;

import com.marketLogic.mvpsurvey.domain.Question;
import com.marketLogic.mvpsurvey.infrastructure.persistence.QuestionRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class QuestionServiceImpl implements QuestionService{

    @Autowired
    private QuestionRepository questionRepository;


    @Override
    public Iterable<Question> addQuestions(List<Question> questions) {
        return questionRepository.saveAll(questions);
    }
}

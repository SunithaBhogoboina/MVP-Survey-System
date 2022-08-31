package com.marketlogic.mvpsurvey.application;

import com.marketlogic.mvpsurvey.domain.Question;
import com.marketlogic.mvpsurvey.infrastructure.persistence.QuestionRepository;
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
    public Iterable<Question> addQuestions(List<Question> questions) throws Exception {
        if(questions.isEmpty()) {
            log.error("Questions payload should consist at least 1 object");
            throw new Exception("Required request body is missing: Questions payload should consist at least 1 object");
        }
        log.info("Successful execution of request");

        return questionRepository.saveAll(questions);
    }
}

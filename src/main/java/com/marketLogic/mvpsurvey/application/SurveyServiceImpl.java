package com.marketlogic.mvpsurvey.application;

import com.marketlogic.mvpsurvey.infrastructure.persistence.SurveyRepository;
import com.marketlogic.mvpsurvey.domain.Survey;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
public class SurveyServiceImpl implements SurveyService{

    @Autowired
    private SurveyRepository surveyRepository;

    @Autowired
    private QuestionService questionService;

    @Override
    public Survey createSurvey(Survey survey) throws Exception {
        if(survey.getSurveyTitle() == null) {
            log.error("Survey payload should not be empty", survey);
            throw new Exception("Required request body is missing: Survey object is empty");
        } else if(survey.getQuestions() == null){
            log.error("Survey payload should contain questions", survey);
            throw new Exception("Required request body is missing: Payload should consist Questions object as well");
        }
        Survey surveyResult = surveyRepository.save(survey);
        log.info("Successful execution of request");

        questionService.addQuestions(survey.getQuestions());

        return surveyResult;
    }

    @Override
    public Iterable<Survey> getAllSurveys() throws Exception {
        Iterable<Survey> surveys = surveyRepository.findAll();
        if(!surveys.iterator().hasNext()) {
            log.error("No Survey exists");
            throw new Exception("No Survey exists");
        }
        log.info("Successful execution of request");

        return surveys;
    }

    @Override
    public Optional<Survey> getSurveyById(Integer surveyId) throws Exception {
        Optional<Survey> survey = surveyRepository.findById(surveyId);
        if(!survey.isPresent()) {
            log.error("No Survey exists");
            throw new Exception("No Survey exists");
        }
        log.info("Successful execution of request");

        return survey;
    }
}

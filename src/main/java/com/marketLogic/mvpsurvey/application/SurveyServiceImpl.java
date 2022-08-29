package com.marketLogic.mvpsurvey.application;

import com.marketLogic.mvpsurvey.domain.Survey;
import com.marketLogic.mvpsurvey.infrastructure.persistence.SurveyRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
public class SurveyServiceImpl implements SurveyService{

    @Autowired
    private SurveyRepository surveyRepository;

    @Override
    public Survey createSurvey(Survey survey) {
        return surveyRepository.save(survey);
    }

    @Override
    public Iterable<Survey> getAllSurveys() {
        return surveyRepository.findAll();
    }

    @Override
    public Optional<Survey> getSurveyById(int surveyId) {
        return surveyRepository.findById(surveyId);
    }
}

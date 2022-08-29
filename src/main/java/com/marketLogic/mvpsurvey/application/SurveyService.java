package com.marketLogic.mvpsurvey.application;

import com.marketLogic.mvpsurvey.domain.Survey;

import java.util.Optional;

public interface SurveyService {
    public Survey createSurvey(Survey survey);
    public Iterable<Survey> getAllSurveys();
    public Optional<Survey> getSurveyById(int surveyId);

}
package com.marketlogic.mvpsurvey.application;

import com.marketlogic.mvpsurvey.domain.Survey;

import java.util.Optional;

public interface SurveyService {
    public Survey createSurvey(Survey survey) throws Exception;
    public Iterable<Survey> getAllSurveys() throws Exception;
    public Optional<Survey> getSurveyById(Integer surveyId) throws Exception;

}
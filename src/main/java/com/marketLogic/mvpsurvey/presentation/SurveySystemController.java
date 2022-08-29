package com.marketLogic.mvpsurvey.presentation;

import com.marketLogic.mvpsurvey.application.SurveyService;
import com.marketLogic.mvpsurvey.domain.Survey;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/surveySystem")
public class SurveySystemController {

    @Autowired
    private SurveyService surveyService;

    @PostMapping(value = "/createSurvey", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Survey> createSurvey(@RequestBody Survey survey) {
        return ResponseEntity.ok(surveyService.createSurvey(survey));
    }

    @GetMapping(value = "/getSurveyById", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Optional<Survey>> getSurvey(@RequestParam int surveyId) {
        return ResponseEntity.ok(surveyService.getSurveyById(surveyId));
    }

    @GetMapping(value = "/getAllSurveys", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Iterable<Survey>> getAllSurveys() {
        return ResponseEntity.ok(surveyService.getAllSurveys());
    }
}

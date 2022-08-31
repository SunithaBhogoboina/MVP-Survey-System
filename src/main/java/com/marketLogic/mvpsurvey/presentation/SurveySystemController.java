package com.marketlogic.mvpsurvey.presentation;

import com.marketlogic.mvpsurvey.domain.Survey;
import com.marketlogic.mvpsurvey.application.SurveyService;
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
    public ResponseEntity<Survey> createSurvey(@RequestBody Survey survey) throws Exception {
        return ResponseEntity.ok(surveyService.createSurvey(survey));
    }

    @GetMapping(value = "/getSurveyById", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Optional<Survey>> getSurveyById(@RequestParam Integer surveyId) throws Exception {
        return ResponseEntity.ok(surveyService.getSurveyById(surveyId));
    }

    @GetMapping(value = "/getAllSurveys", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Iterable<Survey>> getAllSurveys() throws Exception {
        return ResponseEntity.ok(surveyService.getAllSurveys());
    }
}

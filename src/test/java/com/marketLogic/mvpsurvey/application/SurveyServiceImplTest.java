package com.marketlogic.mvpsurvey.application;

import com.marketlogic.mvpsurvey.domain.Question;
import com.marketlogic.mvpsurvey.domain.Survey;
import com.marketlogic.mvpsurvey.domain.Answer;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
@TestInstance(value = TestInstance.Lifecycle.PER_CLASS)
class SurveyServiceImplTest {

    @Autowired
    private com.marketlogic.mvpsurvey.application.SurveyServiceImpl surveyService;

    private Survey survey;

    @BeforeAll
    void generateSurveyObject() {
        survey = new Survey();
        Question question = new Question();
        Answer answer1 = new Answer();
        Answer answer2 = new Answer();
        Answer answer3 = new Answer();
        Answer answer4 = new Answer();
        List<Answer> answerList = new ArrayList<>();
        List<Question> questions = new ArrayList<>();

        survey.setSurveyTitle("Testing Survey ?");
        survey.setSurveyDescription("Testing Survey");

        question.setQuestion("Where does Santa Claus live ?");

        answer1.setAnswer("Hawaii");
        answerList.add(answer1);
        answer2.setAnswer("Finland");
        answerList.add(answer2);
        answer3.setAnswer("Sweden");
        answerList.add(answer3);
        answer4.setAnswer("China");
        answerList.add(answer4);

        question.setAnswers(answerList);
        questions.add(question);

        survey.setQuestions(questions);
    }

    @Test
    void testCreateSurvey() throws Exception {
        Survey surveyResult = surveyService.createSurvey(survey);
        assertNotNull(surveyResult.getSurveyId());
        assertEquals("Testing Survey ?", surveyResult.getSurveyTitle());
    }

    @Test
    void testCreateSurveyWithException() throws Exception {
        Survey survey = new Survey();
        Exception ex = assertThrows(Exception.class, () -> surveyService.createSurvey(survey), "Required request body is missing");
        assertTrue(ex.getMessage().contains("Required request body is missing"));
    }

    @Test
    void testGetAllSurveys() throws Exception {
        Iterable<Survey> surveyResult = surveyService.getAllSurveys();
        assertEquals(1, surveyResult.iterator().next().getQuestions().size());
    }

    @Test
    void testGetSurveyById() throws Exception {
        Optional<Survey> surveyResult = surveyService.getSurveyById(1);
        assertEquals(1, surveyResult.get().getQuestions().size());
    }
}
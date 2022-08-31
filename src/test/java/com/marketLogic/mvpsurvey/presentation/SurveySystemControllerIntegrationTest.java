package com.marketlogic.mvpsurvey.presentation;

import com.marketlogic.mvpsurvey.application.SurveyService;
import com.marketlogic.mvpsurvey.domain.Question;
import com.marketlogic.mvpsurvey.domain.Survey;
import com.marketlogic.mvpsurvey.domain.Answer;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.web.servlet.ServletWebServerFactoryAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

@EnableAutoConfiguration
@SpringBootTest(classes = {ServletWebServerFactoryAutoConfiguration.class, SurveySystemController.class}, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class SurveySystemControllerIntegrationTest {

    @LocalServerPort
    private String port;

    @Autowired
    private TestRestTemplate restTemplate;

    @MockBean
    private SurveyService surveyService;

    @Test
    void createSurvey() {
        Survey survey = new Survey();
        Question question = new Question();
        Answer answer = new Answer();
        List<Answer> answerList = new ArrayList<>();
        List<Question> questions = new ArrayList<>();

        survey.setSurveyTitle("Testing Survey ?");
        survey.setSurveyDescription("Testing Survey");

        question.setQuestion("Where does Santa Claus live ?");

        answer.setAnswer("Hawaii");
        answerList.add(answer);
        answer.setAnswer("Finland");
        answerList.add(answer);
        answer.setAnswer("Sweden");
        answerList.add(answer);
        answer.setAnswer("China");
        answerList.add(answer);

        question.setAnswers(answerList);
        questions.add(question);

        survey.setQuestions(questions);

        ResponseEntity<String> responseEntity = this.restTemplate.postForEntity("http://localhost:" + this.port + "/surveySystem/createSurvey", survey, String.class);
        assertEquals("200 OK", responseEntity.getStatusCode().toString());
    }

    @Test
    void getSurveyById() {
        ResponseEntity<String> responseEntity = this.restTemplate.getForEntity("http://localhost:" + this.port + "/surveySystem/getSurveyById?surveyId=1", String.class);
        assertEquals("200 OK", responseEntity.getStatusCode().toString());
    }

    @Test
    void getAllSurveys() {
        ResponseEntity<String> responseEntity = this.restTemplate.getForEntity("http://localhost:" + this.port + "/surveySystem/getAllSurveys", String.class);
        assertEquals("200 OK", responseEntity.getStatusCode().toString());
    }
}
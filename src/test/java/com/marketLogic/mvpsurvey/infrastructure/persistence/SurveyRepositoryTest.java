package com.marketlogic.mvpsurvey.infrastructure.persistence;

import com.marketlogic.mvpsurvey.domain.Question;
import com.marketlogic.mvpsurvey.domain.Survey;
import com.marketlogic.mvpsurvey.domain.Answer;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@TestInstance(value = TestInstance.Lifecycle.PER_CLASS)
public class SurveyRepositoryTest {

    @Autowired
    private SurveyRepository surveyRepository;

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
    void testSaveSurvey() {
        Survey surveyResult = surveyRepository.save(survey);
        assertNotNull(surveyResult.getSurveyId());
        assertEquals("Testing Survey ?", surveyResult.getSurveyTitle());
    }

    @Test
    void testFindById() {
        surveyRepository.save(survey);
        Optional<Survey> surveyResult = surveyRepository.findById(1);
        assertEquals("Testing Survey ?", surveyResult.get().getSurveyTitle());
    }
}
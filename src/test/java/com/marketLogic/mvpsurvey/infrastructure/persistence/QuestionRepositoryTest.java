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

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@TestInstance(value = TestInstance.Lifecycle.PER_CLASS)
public class QuestionRepositoryTest {

    @Autowired
    private QuestionRepository questionRepository;

    private List<Question> questions;

    @BeforeAll
    void generateQuestionObject() {
        Question question = new Question();
        Answer answer1 = new Answer();
        Answer answer2 = new Answer();
        Answer answer3 = new Answer();
        Answer answer4 = new Answer();
        List<Answer> answerList = new ArrayList<>();
        questions = new ArrayList<>();
        Survey survey = new Survey();
        survey.setSurveyId(1);

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
        question.setSurvey(survey);
        questions.add(question);
    }

    @Test
    void testSaveQuestions() {
        Iterable<Question> questionResult = questionRepository.saveAll(questions);
        assertNotNull(questionResult.iterator().next().getQuestionId());
        assertEquals("Where does Santa Claus live ?", questionResult.iterator().next().getQuestion());
    }

}
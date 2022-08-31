package com.marketlogic.mvpsurvey.infrastructure.persistence;

import com.marketlogic.mvpsurvey.domain.Question;
import com.marketlogic.mvpsurvey.domain.Survey;
import com.marketlogic.mvpsurvey.domain.Answer;
import com.marketlogic.mvpsurvey.domain.CandidateResponse;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@TestInstance(value = TestInstance.Lifecycle.PER_CLASS)
public class CandidateResponseRepositoryTest {

    @Autowired
    private CandidateResponseRepository candidateResponseRepository;

    private CandidateResponse candidateResponse;

    @BeforeAll
    void generateQuestionObject() {
        candidateResponse = new CandidateResponse();
        Answer answer1 = new Answer();
        Answer answer2 = new Answer();
        List<Answer> answerList = new ArrayList<>();
        Survey survey = new Survey();
        survey.setSurveyId(1);

        Question question1 = new Question();
        question1.setQuestionId(1);
        answer1.setQuestion(question1);
        answer1.setAnswer("Hawaii");
        answer1.setAnswerId(2);

        Question question2 = new Question();
        question2.setQuestionId(1);
        answer2.setQuestion(question2);
        answer2.setAnswer("Hawaii");
        answer2.setAnswerId(2);

        answerList.add(answer1);
        answerList.add(answer2);

        candidateResponse.setSurvey(survey);
        candidateResponse.setAnswerList(answerList);
    }

    @Test
    void testSaveCandidateResponse() {
        CandidateResponse candidateResponseResult = candidateResponseRepository.save(candidateResponse);
        assertNotNull(candidateResponseResult.getCandidateResponseId());
    }

}
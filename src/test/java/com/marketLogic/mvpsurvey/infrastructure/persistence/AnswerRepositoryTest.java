package com.marketlogic.mvpsurvey.infrastructure.persistence;

import com.marketlogic.mvpsurvey.domain.Question;
import com.marketlogic.mvpsurvey.domain.Answer;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@TestInstance(value = TestInstance.Lifecycle.PER_CLASS)
public class AnswerRepositoryTest {

    @Autowired
    private AnswerRepository answerRepository;

    private List<Answer> answerList;

    @BeforeAll
    void generateAnswersObject() {
        Question question = new Question();
        Answer answer1 = new Answer();
        Answer answer2 = new Answer();
        Answer answer3 = new Answer();
        Answer answer4 = new Answer();
        answerList = new ArrayList<>();

        question.setQuestionId(1);
        answer1.setQuestion(question);
        answer2.setQuestion(question);
        answer3.setQuestion(question);
        answer4.setQuestion(question);

        answer1.setAnswer("Hawaii");
        answerList.add(answer1);
        answer2.setAnswer("Finland");
        answerList.add(answer2);
        answer3.setAnswer("Sweden");
        answerList.add(answer3);
        answer4.setAnswer("China");
        answerList.add(answer4);
    }

    @Test
    void testSaveAnswers() {
        Iterable<Answer> answerResult = answerRepository.saveAll(answerList);
        assertNotNull(answerResult.iterator().next().getQuestion().getQuestionId());
    }

}
package com.marketlogic.mvpsurvey.application;

import com.marketlogic.mvpsurvey.domain.Question;
import com.marketlogic.mvpsurvey.domain.Answer;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestInstance(value = TestInstance.Lifecycle.PER_CLASS)
public class QuestionServiceImplTest {

    @Autowired
    private QuestionServiceImpl questionService;

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
    }

    @Test
    void testAddQuestions() throws Exception {
        Iterable<Question> question = questionService.addQuestions(questions);
        assertNotNull(question.iterator().next().getQuestionId());
    }

    @Test
    void testAddQuestionsWithException() throws Exception {
        questions = new ArrayList<>();
        Exception ex = assertThrows(Exception.class, () -> questionService.addQuestions(questions), "Required request body is missing");
        assertTrue(ex.getMessage().contains("Required request body is missing"));
    }
}

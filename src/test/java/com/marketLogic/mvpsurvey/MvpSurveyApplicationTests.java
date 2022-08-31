package com.marketlogic.mvpsurvey;

import com.marketlogic.mvpsurvey.presentation.SurveySystemController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class MvpSurveyApplicationTests {

	@Autowired
	private SurveySystemController surveySystemController;

	@Test
	void contextLoads() {
		assertNotNull(surveySystemController);
	}

}

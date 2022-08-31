package com.marketlogic.mvpsurvey.infrastructure.persistence;

import com.marketlogic.mvpsurvey.domain.Survey;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SurveyRepository extends CrudRepository<Survey, String> {
    @Query(value = "SELECT s from Survey s where s.surveyId = ?1")
    Optional<Survey> findById(int surveyId);
}

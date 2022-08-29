package com.marketLogic.mvpsurvey.infrastructure.persistence;

import com.marketLogic.mvpsurvey.domain.Question;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionRepository extends CrudRepository<Question, String> {
}

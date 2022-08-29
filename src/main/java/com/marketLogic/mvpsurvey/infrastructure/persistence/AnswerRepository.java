package com.marketLogic.mvpsurvey.infrastructure.persistence;

import com.marketLogic.mvpsurvey.domain.Answer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnswerRepository extends CrudRepository<Answer, String> {
}

package com.marketLogic.mvpsurvey.infrastructure.persistence;

import com.marketLogic.mvpsurvey.domain.CandidateResponse;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CandidateResponseRepository extends CrudRepository<CandidateResponse, String> {
}

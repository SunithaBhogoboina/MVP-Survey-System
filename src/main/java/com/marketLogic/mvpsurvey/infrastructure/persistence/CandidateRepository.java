package com.marketLogic.mvpsurvey.infrastructure.persistence;

import com.marketLogic.mvpsurvey.domain.Candidate;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CandidateRepository extends CrudRepository<Candidate, String> {
}

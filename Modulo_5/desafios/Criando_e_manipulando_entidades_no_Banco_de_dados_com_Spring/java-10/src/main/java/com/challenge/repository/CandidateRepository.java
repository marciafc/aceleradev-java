package com.challenge.repository;

import com.challenge.entity.Candidate;
import com.challenge.entity.CandidateId;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CandidateRepository extends JpaRepository<Candidate, CandidateId> {

    Optional<Candidate> findByIdUserIdAndIdCompanyIdAndIdAccelerationId(Long userId, Long companyId, Long accelerationId);

    List<Candidate> findByIdCompanyId(Long companyId);

    List<Candidate> findByIdAccelerationId(Long accelerationId);

}

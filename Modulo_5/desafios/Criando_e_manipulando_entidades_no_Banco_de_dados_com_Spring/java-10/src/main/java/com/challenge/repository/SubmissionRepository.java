package com.challenge.repository;

import com.challenge.entity.Submission;
import com.challenge.entity.SubmissionId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;
import java.util.List;

public interface SubmissionRepository extends JpaRepository<Submission, SubmissionId> {

    @Query("select coalesce(max(score), 0) from Submission where id.challenge.id = :challengeId")
    BigDecimal findHigherScoreByChallengeId(@Param("challengeId") Long challengeId);

    @Query("from Submission s " +
            "join s.id.challenge c " +
            "join c.accelerations ac " +
            "where s.id.challenge.id = :challengeId and ac.id = :accelerationId")
    List<Submission> findByChallengeIdAndAccelerationId(@Param("challengeId") Long challengeId,
                                                        @Param("accelerationId") Long accelerationId);


}

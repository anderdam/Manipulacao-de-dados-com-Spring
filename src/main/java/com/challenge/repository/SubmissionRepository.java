package com.challenge.repository;

import com.challenge.entity.Submission;
import com.challenge.entity.SubmissionId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Repository
public interface SubmissionRepository extends JpaRepository<Submission, SubmissionId> {

    @Query("SELECT max(submission.score) " +
            "FROM Submission as submission " +
            "JOIN submission.id.challenge as challenge " +
            "WHERE challenge.id = :challengeId")
    Optional<BigDecimal> findHigherScoreByChallengeId(@Param("challengeId")  Long challengeId);

    @Query("FROM Submission as submission " +
            "JOIN submission.id.challenge as challenge " +
            "JOIN challenge.accelerations as acc " +
            "WHERE challenge.id = :challengeId AND acc.id = :accelerationId")
    List<Submission> findByChallengeIdAndAccelerationId(@Param("challengeId") Long challengeId, @Param("accelerationId") Long accelerationId);
}

package com.challenge.repository;

import com.challenge.entity.Challenge;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ChallengeRepository extends JpaRepository<Challenge, Long> {
    @Query("FROM Challenge as challenge "+
            "INNER JOIN challenge.accelerations as acc "+
            "ON acc.id = :accelerationId "+
            "INNER JOIN challenge.submissions as submission "+
            "WHERE submission.id.user.id = :userId")
    List<Challenge> findByAccelerationIdAndUserId(@Param("accelerationId") Long accelerationId,
                                                  @Param("userId") Long userId);
}
package com.challenge.repository;

import com.challenge.entity.Acceleration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AccelerationRepository extends JpaRepository<Acceleration, Long> {

    Optional<Acceleration> findById(Long id);

    @Query("SELECT acceleration" +
            " FROM Acceleration as acceleration" +
            " INNER JOIN acceleration.candidates as candidate" +
            " WHERE candidate.id.company.id = :companyId")
    List<Acceleration> findByCompanyId(@Param("companyId") Long companyId);
}

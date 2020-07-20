package com.challenge.repository;

import com.challenge.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Long> {

    @Query("SELECT distinct company " +
            "FROM Company as company " +
            "JOIN company.candidates as candidate" +
            " WHERE candidate.id.acceleration.id = :accelerationId")
    List<Company> findByAccelerationId(@Param("accelerationId") Long accelerationId);

    @Query("FROM Company as company " +
            "INNER JOIN company.candidates as candidate " +
            "WHERE candidate.id.user.id = :userId")
    List<Company> findByUserId(Long userId);
}

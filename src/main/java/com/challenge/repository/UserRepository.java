package com.challenge.repository;

import com.challenge.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Query("SELECT DISTINCT user" +
            " FROM User as user" +
            " INNER JOIN user.candidates as candidate" +
            " WHERE candidate.id.acceleration.name = :name")
    List<User> findByAccelerationName(@Param("name") String name);

    @Query("SELECT DISTINCT user" +
            " FROM User as user" +
            " INNER JOIN user.candidates as candidate" +
            " WHERE candidate.id.company.id = :companyId")
    List<User> findByCompanyId(@Param("companyId") Long companyId);


}

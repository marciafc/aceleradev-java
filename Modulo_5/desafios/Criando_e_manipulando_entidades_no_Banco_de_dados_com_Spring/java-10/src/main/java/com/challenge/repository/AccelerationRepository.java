package com.challenge.repository;

import com.challenge.entity.Acceleration;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AccelerationRepository extends JpaRepository<Acceleration, Long> {

    List<Acceleration> findByCandidatesIdCompanyId(Long companyId);
}

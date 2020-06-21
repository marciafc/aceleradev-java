package com.challenge.repository;

import com.challenge.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {

    List<User> findByCandidatesIdAccelerationName(String name);

    List<User> findByCandidatesIdCompanyId(Long id);

}

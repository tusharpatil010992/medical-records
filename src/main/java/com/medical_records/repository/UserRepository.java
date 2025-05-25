package com.medical_records.repository;

import com.medical_records.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
    boolean existsByUsername(String username);
}

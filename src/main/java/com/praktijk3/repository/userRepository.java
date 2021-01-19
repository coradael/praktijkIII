package com.praktijk3.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.praktijk3.model.user;

@Repository("userRepository")
public interface userRepository extends JpaRepository<user, Long> {
    Optional<user> findByEmail(String email);

    Optional<user> findByUsernameOrEmail(String username, String email);

    List<user> findByIdIn(List<Long> userIds);

    Optional<user> findByUsername(String username);

    Boolean existsByUsername(String username);

    Boolean existsByEmail(String email);
}
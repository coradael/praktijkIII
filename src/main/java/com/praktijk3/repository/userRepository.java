package com.praktijk3.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.praktijk3.model.user;

@Repository("userRepository")
public interface userRepository extends JpaRepository<user, Long> {
 
 user findByEmail(String email);
}
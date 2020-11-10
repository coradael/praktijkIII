package com.praktijk3.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.praktijk3.model.role;

@Repository("roleRepository")
public interface roleRepository extends JpaRepository<role, Integer> {

 role findByRole(String role);
}
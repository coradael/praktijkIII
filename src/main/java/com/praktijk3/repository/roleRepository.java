package com.praktijk3.repository;

import com.praktijk3.model.role;
import com.praktijk3.model.roleName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface roleRepository extends JpaRepository<role, Long> {
    Optional<role> findByName(roleName roleName);
}
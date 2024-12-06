package com.lds.student_currency_system.infra.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lds.student_currency_system.domain.model.Professor;

@Repository
public interface ProfessorRepository extends JpaRepository<Professor, Long> {
    boolean existsByEmail(String email);
    Float findSalaryByEmail(String email);
    Optional<Professor> findByEmail(String email);
}
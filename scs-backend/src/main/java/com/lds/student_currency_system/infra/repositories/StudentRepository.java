package com.lds.student_currency_system.infra.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lds.student_currency_system.domain.model.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    boolean existsByEmail(String email);
    Optional<Student> findByEmail(String email);
}
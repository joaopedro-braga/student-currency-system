package com.lds.student_currency_system.domain.service;

import java.util.List;
import java.util.Optional;

import com.lds.student_currency_system.domain.model.Professor;
import com.lds.student_currency_system.domain.model.Student;
import com.lds.student_currency_system.domain.model.Transfer;

public interface ProfessorService {
    Professor save(Professor professor);

    Optional<Professor> findById(Long id);

    List<Professor> findAll();

    void deleteById(Long id);

    Professor update(Professor professor);

    Transfer makeTransfer(Long professorId, Transfer transfer, Student student) throws Exception;
}
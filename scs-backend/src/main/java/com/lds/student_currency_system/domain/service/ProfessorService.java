package com.lds.student_currency_system.domain.service;

import java.util.List;
import java.util.Optional;

import com.lds.student_currency_system.application.dto.ProfessorRequest;
import com.lds.student_currency_system.application.dto.ProfessorResponse;
import com.lds.student_currency_system.application.dto.TransferRequest;
import com.lds.student_currency_system.application.dto.TransferResponse;
import com.lds.student_currency_system.domain.model.Professor;

public interface ProfessorService {
    ProfessorResponse createProfessor(ProfessorRequest professor);

    Optional<ProfessorResponse> findById(Long id);

    List<ProfessorResponse> findAll();

    void deleteById(Long id);

    ProfessorResponse update(Long id, ProfessorRequest professorRequest);

    Professor findByUsername(String username);

    void aumentarSalarioProfessores();

    public TransferResponse makeTransfer(Professor sender, TransferRequest request);

}
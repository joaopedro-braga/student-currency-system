package com.lds.student_currency_system.domain.service.impl;

import com.lds.student_currency_system.infra.repositories.ProfessorRepository;
import com.lds.student_currency_system.infra.repositories.StudentRepository;
import com.lds.student_currency_system.infra.repositories.TransferRepository;
import com.lds.student_currency_system.domain.model.Professor;
import com.lds.student_currency_system.domain.model.Student;
import com.lds.student_currency_system.domain.model.Transfer;
import com.lds.student_currency_system.domain.service.ProfessorService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProfessorServiceImpl implements ProfessorService {

    private final ProfessorRepository professorRepository;
    private final StudentRepository studentRepository;
    private final TransferRepository transferRepository;

    @Override
    public Professor save(Professor professor) {
        return professorRepository.save(professor);
    }

    @Override
    public Optional<Professor> findById(Long id) {
        return professorRepository.findById(id);
    }

    @Override
    public List<Professor> findAll() {
        return professorRepository.findAll();
    }

    @Override
    public void deleteById(Long id) {
        professorRepository.deleteById(id);
    }

    @Override
    public Professor update(Professor professor) {
        if(professorRepository.existsById(professor.getId())) {
            return professorRepository.save(professor);
        }
        throw new RuntimeException("Professor not found!");
    }

    @Override
    @Transactional
    public Transfer makeTransfer(Long professorId, Transfer transfer, Student student) throws Exception {
        Professor professor = findById(professorId).orElseThrow(() -> new Exception("Professor not found!"));

        if (professor.getBalance() < transfer.getCoinQuantity()) {
            throw new Exception("Insufficient coins to realize the transfer!");
        }

        transfer.setTransactor(professor);
        studentRepository.save(student);
        transferRepository.save(transfer);

        professor.setBalance(professor.getBalance() - transfer.getCoinQuantity());
        professorRepository.save(professor);

        return transfer;
    }
}
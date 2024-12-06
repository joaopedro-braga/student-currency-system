package com.lds.student_currency_system.domain.service.impl;

import com.lds.student_currency_system.infra.repositories.InstitutionRepository;
import com.lds.student_currency_system.infra.repositories.ProfessorRepository;
import com.lds.student_currency_system.infra.repositories.StudentRepository;
import com.lds.student_currency_system.infra.repositories.TransferRepository;

import jakarta.mail.MessagingException;

import com.lds.student_currency_system.application.dto.ProfessorRequest;
import com.lds.student_currency_system.application.dto.ProfessorResponse;
import com.lds.student_currency_system.application.dto.TransferRequest;
import com.lds.student_currency_system.application.dto.TransferResponse;
import com.lds.student_currency_system.application.mapper.ProfessorMapper;
import com.lds.student_currency_system.application.mapper.TransferMapper;
import com.lds.student_currency_system.domain.model.Institution;
import com.lds.student_currency_system.domain.model.Professor;
import com.lds.student_currency_system.domain.model.Student;
import com.lds.student_currency_system.domain.model.Transfer;
import com.lds.student_currency_system.domain.service.ProfessorService;
import lombok.RequiredArgsConstructor;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProfessorServiceImpl implements ProfessorService {

    private final ProfessorRepository professorRepository;
    private final TransferRepository transferRepository;
    private final InstitutionRepository institutionRepository;
    private final StudentRepository studentRepository;
    private final EmailService emailService;

    @Override
    public ProfessorResponse createProfessor(ProfessorRequest professorRequest) {

        Institution institution = institutionRepository.findById(professorRequest.institutionId())
                .orElseThrow(() -> new RuntimeException("Institution not found"));

        if (professorRepository.existsByEmail(professorRequest.email()))
            throw new RuntimeException("Email already in use!");

        Professor professor = professorRepository.save(ProfessorMapper.toProfessor(professorRequest, institution));
        createTransfer(professor);
        return ProfessorMapper.toProfessorResponse(professor);
    }

    @Override
    public Optional<ProfessorResponse> findById(Long id) {
        Optional<Professor> professorOpt = professorRepository.findById(id);

        if (professorOpt.isPresent()) {
            ProfessorResponse response = ProfessorMapper.toProfessorResponse(professorOpt.get());
            return Optional.of(response);
        }

        return Optional.empty();
    }

    @Override
    public List<ProfessorResponse> findAll() {
        List<Professor> professors = professorRepository.findAll();
        return ProfessorMapper.toProfessorResponseList(professors);
    }

    @Override
    public void deleteById(Long id) {
        professorRepository.deleteById(id);
    }

    @Override
    public ProfessorResponse update(Long id, ProfessorRequest professorRequest) {

        Institution institution = institutionRepository.findById(professorRequest.institutionId())
                .orElseThrow(() -> new RuntimeException("Institution not found"));

        Professor professor = ProfessorMapper.toProfessor(professorRequest, institution);
        professor.setId(id);

        if (professorRepository.existsById(professor.getId())) {
            professor = professorRepository.save(professor);
            return ProfessorMapper.toProfessorResponse(professor);
        }
        throw new RuntimeException("Professor not found!");
    }

    @Override
    public Professor findByUsername(String username) {
        return professorRepository.findByEmail(username)
                .orElseThrow(() -> new RuntimeException("Professor not found!"));
    }

    @Override
    @Transactional
    @Scheduled(cron = "0 0 0 1 1/6 *")
    public void aumentarSalarioProfessores() {
        List<Professor> professores = professorRepository.findAll();
        List<Transfer> transfers = new ArrayList<>();

        for (Professor professor : professores) {
            professor.setBalance(professor.getBalance() + 1000);

            transfers.add(new Transfer(
                    professor.getInstitution(),
                    professor,
                    1000,
                    "Institutional credit: Semester bonus for professor"));
        }

        transferRepository.saveAll(transfers);
        professorRepository.saveAll(professores);
    }

    @Override
    @Transactional
    public TransferResponse makeTransfer(Professor sender, TransferRequest request) {

        Student receiver = studentRepository.findById(request.receiverId())
                .orElseThrow(() -> new RuntimeException("Student not found!"));

        if (request.coinQuantity() <= 0) {
            throw new IllegalArgumentException("Coin quantity must be positive.");
        }

        if (sender.getBalance() < request.coinQuantity()) {
            throw new RuntimeException("Insufficient coins to realize the transfer!");
        }

        sender.setBalance(sender.getBalance() - request.coinQuantity());
        professorRepository.save(sender);

        receiver.setBalance(receiver.getBalance() + request.coinQuantity());
        studentRepository.save(receiver);

        Transfer transfer = TransferMapper.toTransfer(sender, receiver, request.coinQuantity(), request.description());

        try {
            emailService.sendTransferNotification("joao.psbraga6@gmail.com", receiver.getName(), sender.getName(), request.coinQuantity());
        } catch (MessagingException e) {
            e.printStackTrace();
        }

        return TransferMapper.toTransferResponse(transferRepository.save(transfer), sender.getId());

    }

    private void createTransfer(Professor professor) {
        Transfer transfer = new Transfer(professor.getInstitution(), professor, 1000,
                "Institutional credit: Semester bonus for professor");
        transferRepository.save(transfer);
    }
}
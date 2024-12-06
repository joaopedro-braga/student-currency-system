package com.lds.student_currency_system.application.api;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lds.student_currency_system.application.dto.ProfessorRequest;
import com.lds.student_currency_system.application.dto.ProfessorResponse;
import com.lds.student_currency_system.application.dto.TransferRequest;
import com.lds.student_currency_system.application.dto.TransferResponse;
import com.lds.student_currency_system.domain.model.Professor;
import com.lds.student_currency_system.domain.service.ProfessorService;

import java.util.List;

@RestController
@RequestMapping("/api/professors")
@RequiredArgsConstructor
public class ProfessorController {

    private final ProfessorService professorService;

    @PostMapping
    public ResponseEntity<ProfessorResponse> createProfessor(@RequestBody ProfessorRequest requestProfessor) {
        ProfessorResponse savedProfessor = professorService.createProfessor(requestProfessor);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedProfessor);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProfessorResponse> getProfessorById(@PathVariable Long id) {
        return professorService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<ProfessorResponse>> getAllProfessors() {
        List<ProfessorResponse> professors = professorService.findAll();
        return ResponseEntity.ok(professors);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProfessorResponse> updateProfessor(@PathVariable Long id,
            @RequestBody ProfessorRequest professorRequest) {
        ProfessorResponse updatedProfessor = professorService.update(id, professorRequest);
        return ResponseEntity.ok(updatedProfessor);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProfessor(@PathVariable Long id) {
        professorService.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/balance")
    public ResponseEntity<Float> getUserBalance(@AuthenticationPrincipal Professor professor) {
        Professor newProfessor = professorService.findByUsername(professor.getUsername());
        return ResponseEntity.ok(newProfessor.getBalance());
    }

    @PostMapping("/transfers")
    public ResponseEntity<TransferResponse> makeTransfer(@RequestBody TransferRequest request,
            @AuthenticationPrincipal Professor professor) {

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(professorService.makeTransfer(professor, request));
    }
}
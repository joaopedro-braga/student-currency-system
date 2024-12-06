package com.lds.student_currency_system.application.api;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lds.student_currency_system.application.dto.InstitutionRequest;
import com.lds.student_currency_system.application.dto.InstitutionResponse;
import com.lds.student_currency_system.domain.service.InstitutionService;

import java.util.List;

@RestController
@RequestMapping("/api/institutions")
@RequiredArgsConstructor
public class InstitutionController {

    private final InstitutionService institutionService;

    @PostMapping
    public ResponseEntity<InstitutionResponse> createInstitution(@RequestBody InstitutionRequest institutionRequest) {
        InstitutionResponse savedInstitution = institutionService.save(institutionRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedInstitution);
    }

    @GetMapping("/{id}")
    public ResponseEntity<InstitutionResponse> getInstitutionById(@PathVariable Long id) {
        return institutionService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<InstitutionResponse>> getAllInstitutions() {
        List<InstitutionResponse> institutions = institutionService.findAll();
        return ResponseEntity.ok(institutions);
    }

    @PutMapping("/{id}")
    public ResponseEntity<InstitutionResponse> updateInstitution(@PathVariable Long id, @RequestBody InstitutionRequest institutionRequest) {
        InstitutionResponse updatedInstitution = institutionService.update(id, institutionRequest);
        return ResponseEntity.ok(updatedInstitution);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteInstitution(@PathVariable Long id) {
        institutionService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
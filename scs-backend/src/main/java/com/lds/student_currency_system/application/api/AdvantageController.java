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

import com.lds.student_currency_system.application.dto.AdvantageRequest;
import com.lds.student_currency_system.application.dto.AdvantageResponse;
import com.lds.student_currency_system.domain.model.Company;
import com.lds.student_currency_system.domain.service.AdvantageService;
import java.util.List;

@RestController
@RequestMapping("/api/advantages")
@RequiredArgsConstructor
public class AdvantageController {

    private final AdvantageService advantageService;

    @PostMapping
    public ResponseEntity<AdvantageResponse> createAdvantage(@RequestBody AdvantageRequest advantage) {
        AdvantageResponse savedAdvantage = advantageService.save(advantage);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedAdvantage);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AdvantageResponse> getAdvantageById(@PathVariable Long id) {
        return advantageService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<AdvantageResponse>> getAllAdvantages() {
        List<AdvantageResponse> advantages = advantageService.findAll();
        return ResponseEntity.ok(advantages);
    }

    @GetMapping("/company")
    public ResponseEntity<List<AdvantageResponse>> getAllAdvantagesByCompany(@AuthenticationPrincipal Company company) {
        List<AdvantageResponse> advantages = advantageService.findAllByCompany(company);
        return ResponseEntity.ok(advantages);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AdvantageResponse> updateAdvantage(@PathVariable Long id, @RequestBody AdvantageRequest advantage) {
        AdvantageResponse updatedAdvantage = advantageService.update(id, advantage);
        return ResponseEntity.ok(updatedAdvantage);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAdvantage(@PathVariable Long id) {
        advantageService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
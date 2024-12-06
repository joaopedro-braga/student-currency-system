package com.lds.student_currency_system.application.api;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lds.student_currency_system.application.dto.CompanyRequest;
import com.lds.student_currency_system.application.dto.CompanyResponse;
import com.lds.student_currency_system.domain.model.Company;
import com.lds.student_currency_system.domain.service.CompanyService;

import java.util.List;

@RestController
@RequestMapping("/api/companies")
@RequiredArgsConstructor
public class CompanyController {

    private final CompanyService companyService;

    @GetMapping("/{id}")
    public ResponseEntity<CompanyResponse> getCompanyById(@PathVariable Long id) {
        return companyService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<CompanyResponse>> getAllCompanies() {
        List<CompanyResponse> companies = companyService.findAll();
        return ResponseEntity.ok(companies);
    }

    @PutMapping()
    public ResponseEntity<CompanyResponse> updateCompany(@AuthenticationPrincipal Company auth, @RequestBody CompanyRequest company) {
        CompanyResponse updatedCompany = companyService.update(auth.getId(), company);
        return ResponseEntity.ok(updatedCompany);
    }

    @DeleteMapping()
    public ResponseEntity<Void> deleteCompany(@AuthenticationPrincipal Company company) {
        companyService.deleteById(company.getId());
        return ResponseEntity.noContent().build();
    }
}
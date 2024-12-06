package com.lds.student_currency_system.domain.service.impl;

import com.lds.student_currency_system.infra.repositories.InstitutionRepository;
import com.lds.student_currency_system.application.dto.InstitutionRequest;
import com.lds.student_currency_system.application.dto.InstitutionResponse;
import com.lds.student_currency_system.application.mapper.InstitutionMapper;
import com.lds.student_currency_system.domain.model.Institution;
import com.lds.student_currency_system.domain.service.InstitutionService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class InstitutionServiceImpl implements InstitutionService {

    private final InstitutionRepository institutionRepository;

    @Override
    public InstitutionResponse save(InstitutionRequest institutionRequest) {
        if(institutionRepository.existsByEmail(institutionRequest.email()))
            throw new RuntimeException("Email already in use!");
            
        Institution institution = InstitutionMapper.toInstitution(institutionRequest);
        return InstitutionMapper.toInstitutionResponse(institutionRepository.save(institution));
    }

    @Override
    public Optional<InstitutionResponse> findById(Long id) {
        Optional<Institution> institutionOpt = institutionRepository.findById(id);

        if (institutionOpt.isPresent()) {
            InstitutionResponse response = InstitutionMapper.toInstitutionResponse(institutionOpt.get());
            return Optional.of(response); 
        }

        return Optional.empty();
    }

    @Override
    public List<InstitutionResponse> findAll() {
        return InstitutionMapper.toInstitutionResponseList(institutionRepository.findAll());
    }

    @Override
    public void deleteById(Long id) {
        institutionRepository.deleteById(id);
    }

    @Override
    public InstitutionResponse update(Long id, InstitutionRequest institutionRequest) {

        Institution institution = InstitutionMapper.toInstitution(institutionRequest);
        institution.setId(id);

        if(institutionRepository.existsById(institution.getId())) {
            return InstitutionMapper.toInstitutionResponse(institutionRepository.save(institution));
        }
        throw new RuntimeException("Institution not found!");
    }
}
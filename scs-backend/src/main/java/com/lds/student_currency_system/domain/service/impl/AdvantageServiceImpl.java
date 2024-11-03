package com.lds.student_currency_system.domain.service.impl;

import com.lds.student_currency_system.infra.repositories.AdvantageRepository;
import com.lds.student_currency_system.domain.model.Advantage;
import com.lds.student_currency_system.domain.service.AdvantageService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AdvantageServiceImpl implements AdvantageService {

    private final AdvantageRepository advantageRepository;

    @Override
    public Advantage save(Advantage advantage) {
        return advantageRepository.save(advantage);
    }

    @Override
    public Optional<Advantage> findById(Long id) {
        return advantageRepository.findById(id);
    }

    @Override
    public List<Advantage> findAll() {
        return advantageRepository.findAll();
    }

    @Override
    public void deleteById(Long id) {
        advantageRepository.deleteById(id);
    }

    @Override
    public Advantage update(Advantage advantage) {
        if(advantageRepository.existsById(advantage.getId())) {
            return advantageRepository.save(advantage);
        }
        throw new RuntimeException("Advantage not found!");
    }
}
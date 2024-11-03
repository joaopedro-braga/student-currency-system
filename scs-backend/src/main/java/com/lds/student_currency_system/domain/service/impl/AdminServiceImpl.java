package com.lds.student_currency_system.domain.service.impl;

import com.lds.student_currency_system.infra.repositories.AdminRepository;
import com.lds.student_currency_system.domain.model.Admin;
import com.lds.student_currency_system.domain.service.AdminService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AdminServiceImpl implements AdminService {

    private final AdminRepository adminRepository;

    @Override
    public Admin save(Admin admin) {
        return adminRepository.save(admin);
    }

    @Override
    public Optional<Admin> findById(Long id) {
        return adminRepository.findById(id);
    }

    @Override
    public List<Admin> findAll() {
        return adminRepository.findAll();
    }

    @Override
    public void deleteById(Long id) {
        adminRepository.deleteById(id);
    }

    @Override
    public Admin update(Admin admin) {
        if(adminRepository.existsById(admin.getId())) {
            return adminRepository.save(admin);
        }
        throw new RuntimeException("Admin não encontrado.");
    }

    @Override
    public Optional<Admin> findByEmail(String email) {
        return adminRepository.findByEmail(email);
    }
}
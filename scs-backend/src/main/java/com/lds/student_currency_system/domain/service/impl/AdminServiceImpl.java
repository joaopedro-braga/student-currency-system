package com.lds.student_currency_system.domain.service.impl;

import com.lds.student_currency_system.infra.repositories.AdminRepository;
import com.lds.student_currency_system.domain.model.Admin;
import com.lds.student_currency_system.domain.service.AdminService;

import lombok.RequiredArgsConstructor;

import java.util.Optional;

import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AdminServiceImpl implements AdminService {

    private final AdminRepository adminRepository;

    @Override
    public Admin save(Admin admin) {
        return adminRepository.save(admin);
    }

    @Override
    public Optional<Admin> findByEmail(String email) {
        return adminRepository.findByEmail(email);
    }

}
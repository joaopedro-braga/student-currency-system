package com.lds.student_currency_system.domain.service;

import java.util.Optional;

import com.lds.student_currency_system.domain.model.Admin;

public interface AdminService {
    Admin save(Admin admin);
    
    Optional<Admin> findByEmail(String email);
}
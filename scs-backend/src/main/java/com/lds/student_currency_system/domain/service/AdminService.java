package com.lds.student_currency_system.domain.service;

import java.util.List;
import java.util.Optional;

import com.lds.student_currency_system.domain.model.Admin;

public interface AdminService {
    Admin save(Admin admin);

    Optional<Admin> findById(Long id);

    Optional<Admin> findByEmail(String email);

    List<Admin> findAll();

    void deleteById(Long id);

    Admin update(Admin admin);
}
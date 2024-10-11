package com.lds.student_currency_system.application.domain.service;

import com.lds.student_currency_system.application.domain.model.Admin;

import java.util.List;
import java.util.Optional;

public interface AdminService {
    Admin save(Admin admin);

    Optional<Admin> findById(Long id);

    List<Admin> findAll();

    void deleteById(Long id);

    Admin update(Admin admin);
}
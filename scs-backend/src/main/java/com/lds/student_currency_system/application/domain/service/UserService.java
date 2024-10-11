package com.lds.student_currency_system.application.domain.service;

import com.lds.student_currency_system.application.domain.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    User save(User user);

    Optional<User> findById(Long id);

    Optional<User> findByEmail(String email);

    List<User> findAll();

    void deleteById(Long id);

    User update(User user);
}
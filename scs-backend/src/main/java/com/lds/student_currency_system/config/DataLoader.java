package com.lds.student_currency_system.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import com.lds.student_currency_system.domain.model.Admin;
import com.lds.student_currency_system.domain.service.AdminService;
import com.lds.student_currency_system.domain.service.UserService;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class DataLoader implements CommandLineRunner {

    private final AdminService adminService;
    private final UserService userService;

    @Override
    public void run(String... args) throws Exception {

        if(!userService.existByEmail("admin@gmail.com")){
            Admin admin = new Admin("Administrator", "admin@gmail.com", new BCryptPasswordEncoder().encode("123456"));
            adminService.save(admin);
        }
    }
}
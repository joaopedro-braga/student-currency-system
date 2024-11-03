package com.lds.student_currency_system.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import com.lds.student_currency_system.domain.model.Admin;
import com.lds.student_currency_system.domain.model.User;
import com.lds.student_currency_system.domain.service.AdminService;
import com.lds.student_currency_system.infra.security.TokenService;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class DataLoader implements CommandLineRunner {

    private final AdminService adminService;

    private final TokenService tokenService;
    private final AuthenticationManager authenticationManager;

    @Override
    public void run(String... args) throws Exception {

        if (adminService.findByEmail("admin@mail.com").isEmpty()) {
            Admin admin = new Admin("Administrator", "admin@mail.com", new BCryptPasswordEncoder().encode("1234"));
            adminService.save(admin);
        }

        var usernamePassword = new UsernamePasswordAuthenticationToken("admin@mail.com", "1234");
        var user = (User) this.authenticationManager.authenticate(usernamePassword).getPrincipal();
        System.out.println("token: " + tokenService.generateToken(user));
    }
}
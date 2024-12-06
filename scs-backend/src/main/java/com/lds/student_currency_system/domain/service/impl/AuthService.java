package com.lds.student_currency_system.domain.service.impl;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

import com.lds.student_currency_system.application.dto.AuthenticationResponse;
import com.lds.student_currency_system.domain.Exception.UserAlreadyExistsException;
import com.lds.student_currency_system.domain.model.User;
import com.lds.student_currency_system.infra.security.TokenService;
import com.lds.student_currency_system.domain.service.UserService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final TokenService tokenService;
    private final AuthenticationManager authenticationManager;
    private final UserService userService;

    public AuthenticationResponse authenticate(String email, String password) {
        var usernamePassword = new UsernamePasswordAuthenticationToken(email, password);
        var user = (User) authenticationManager.authenticate(usernamePassword).getPrincipal();
        var token = tokenService.generateToken(user);
        return new AuthenticationResponse(token, user.getRole());
    }

    public void validateAndRegisterUser(String email, Runnable registrationAction) {
        if (userService.existByEmail(email)) {
            throw new UserAlreadyExistsException("A user with this email already exists!");
        }
        registrationAction.run();
    }
}


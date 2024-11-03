package com.lds.student_currency_system.application.api;

import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;

import com.lds.student_currency_system.application.dto.AuthenticationRequest;
import com.lds.student_currency_system.application.dto.LoginResponse;
import com.lds.student_currency_system.application.dto.RegisterCompanyRequest;
import com.lds.student_currency_system.application.dto.RegisterStudentRequest;
import com.lds.student_currency_system.application.mapper.CompanyMapper;
import com.lds.student_currency_system.application.mapper.StudentMapper;
import com.lds.student_currency_system.infra.repositories.CompanyRepository;
import com.lds.student_currency_system.infra.repositories.StudentRepository;
import com.lds.student_currency_system.infra.security.TokenService;
import com.lds.student_currency_system.domain.Exception.UserAlreadyExistsException;
import com.lds.student_currency_system.domain.model.User;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthenticationController {

    private final TokenService tokenService;
    private final AuthenticationManager authenticationManager;
    private final StudentRepository studentRepository;
    private final CompanyRepository companyRepository;

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody @Valid AuthenticationRequest authentication){
        return ResponseEntity.ok(authenticate(authentication.login(), authentication.password()));
    }

    @PostMapping("/register/student")
    public ResponseEntity<LoginResponse> registerStudent(@RequestBody @Valid RegisterStudentRequest request){
        if (this.studentRepository.existsByEmail(request.email()))
            throw new UserAlreadyExistsException("A user with this email already exists!");

            System.out.println("request: " + request);
        this.studentRepository.save(StudentMapper.toStudent(request));
        return ResponseEntity.ok(authenticate(request.email(), request.password()));
    }

    @PostMapping("/register/company")
    public ResponseEntity<LoginResponse> registerCompany(@RequestBody @Valid RegisterCompanyRequest request){
        if(this.companyRepository.existsByEmail(request.email())) 
            throw new UserAlreadyExistsException("A user with this email already exists!");
        
        this.companyRepository.save(CompanyMapper.toCompany(request));
        return ResponseEntity.ok(authenticate(request.email(), request.password()));
    }

    private LoginResponse authenticate(String email, String password) {
        var usernamePassword = new UsernamePasswordAuthenticationToken(email, password);
        var user = (User) this.authenticationManager.authenticate(usernamePassword).getPrincipal();
        var token = tokenService.generateToken(user);

        return new LoginResponse(token, user.getRole());
    }
    
}

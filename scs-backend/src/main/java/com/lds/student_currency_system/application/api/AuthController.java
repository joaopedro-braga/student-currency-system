package com.lds.student_currency_system.application.api;

import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;

import com.lds.student_currency_system.application.dto.AuthenticationRequest;
import com.lds.student_currency_system.application.dto.AuthenticationResponse;
import com.lds.student_currency_system.application.dto.CompanyRequest;
import com.lds.student_currency_system.application.dto.StudentRequest;
import com.lds.student_currency_system.infra.security.TokenService;
import com.lds.student_currency_system.domain.model.User;
import com.lds.student_currency_system.domain.service.CompanyService;
import com.lds.student_currency_system.domain.service.StudentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final TokenService tokenService;
    private final AuthenticationManager authenticationManager;
    private final StudentService studentService;
    private final CompanyService companyService;

    @PostMapping("/login")
    public ResponseEntity<AuthenticationResponse> login(@RequestBody @Valid AuthenticationRequest authentication){
        return ResponseEntity.ok(authenticate(authentication.login(), authentication.password()));
    }
  
    @PostMapping("/register/student")
    public ResponseEntity<AuthenticationResponse> registerStudent(@RequestBody @Valid StudentRequest request){
        studentService.save(request);
        return ResponseEntity.ok(authenticate(request.email(), request.password()));
    }

    @PostMapping("/register/company")
    public ResponseEntity<AuthenticationResponse> registerCompany(@RequestBody @Valid CompanyRequest request){
        companyService.save(request);
        return ResponseEntity.ok(authenticate(request.email(), request.password()));
    }

    private AuthenticationResponse authenticate(String email, String password) {
        var usernamePassword = new UsernamePasswordAuthenticationToken(email, password);
        var user = (User) this.authenticationManager.authenticate(usernamePassword).getPrincipal();
        var token = tokenService.generateToken(user);

        return new AuthenticationResponse(token, user.getRole());
    }
    
}

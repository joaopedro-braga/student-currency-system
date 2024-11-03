package com.lds.student_currency_system.infra.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Autowired
    SecurityFilter securityFilter;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        return  httpSecurity
                .csrf(csrf -> csrf.disable())
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .headers(headers -> headers
                    .frameOptions(frameOptions -> frameOptions.sameOrigin()) 
                )
                .authorizeHttpRequests(authorize -> authorize
                        .requestMatchers("/swagger-ui/**", "/v3/api-docs/**", "/h2-console/**", "/api/auth/**").permitAll()
                        .requestMatchers("/api/admins").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.POST, "/api/institutions", "/api/professors", "/api/users").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.PUT, "/api/institutions", "/api/professors").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.POST, "/api/advantages", "/api/companies").hasRole("COMPANY")
                        .requestMatchers(HttpMethod.PUT, "/api/advantages", "/api/companies").hasRole( "COMPANY")
                        .requestMatchers(HttpMethod.POST, "/api/students").hasRole("STUDENT")
                        .requestMatchers(HttpMethod.PUT, "/api/students").hasRole( "STUDENT")
                        .requestMatchers(HttpMethod.POST, "/api/transfers").hasAnyRole("STUDENT", "PROFESSOR")
                        .requestMatchers("/api/vouchers").hasAnyRole("STUDENT", "COMPANY")
                        .anyRequest().authenticated()
                )
                .addFilterBefore(securityFilter, UsernamePasswordAuthenticationFilter.class)
                .build();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
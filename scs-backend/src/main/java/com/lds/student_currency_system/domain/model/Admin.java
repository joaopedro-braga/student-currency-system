package com.lds.student_currency_system.domain.model;

import com.lds.student_currency_system.domain.enums.UserRole;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "admins")
@Getter
@Setter
@NoArgsConstructor
public class Admin extends User {
    public Admin(String name, String email, String password) {
        super(name, email, password, UserRole.ADMIN);
    }
}
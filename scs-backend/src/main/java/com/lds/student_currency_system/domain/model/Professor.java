package com.lds.student_currency_system.domain.model;

import com.lds.student_currency_system.domain.enums.UserRole;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "professors")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Professor extends User {

    public Professor(String name, String email, String password, String cpf, String department, Institution institution, float balance) {
        super(name, email, password, UserRole.PROFESSOR);
        this.cpf = cpf;
        this.department = department;
        this.institution = institution;
        this.balance = balance;
    }

    @Column(nullable = false)
    private String cpf;

    @Column(nullable = false)
    private String department;

    @ManyToOne
    @JoinColumn(name = "institution_id", nullable = false)
    private Institution institution;

    @Column(nullable = false)
    private float balance;
}

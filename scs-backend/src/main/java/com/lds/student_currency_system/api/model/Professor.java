package com.lds.student_currency_system.api.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "professors")
@Getter
@Setter
@NoArgsConstructor
public class Professor extends User {

    public Professor(String name, String email, String password, String cpf, String department, Institution institution, float balance) {
        super(name, email, password);
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

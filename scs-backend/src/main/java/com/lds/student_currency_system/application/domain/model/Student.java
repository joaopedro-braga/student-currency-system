package com.lds.student_currency_system.application.domain.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "students") 
@Getter
@Setter
@NoArgsConstructor
public class Student extends User {

    public Student(String name, String email, String password, String cpf, String address, Institution institution, String course, float balance) {
        super(name, email, password);
        this.cpf = cpf;
        this.address = address;
        this.institution = institution;
        this.course = course;
        this.balance = balance;
    }
    
    @Column(nullable = false)
    private String cpf;

    @Column(nullable = false)
    private String address;

    @ManyToOne
    @JoinColumn(name = "institution_id", nullable = false)
    private Institution institution;

    @Column(nullable = false)
    private String course;

    @Column(nullable = false)
    private float balance;
}
